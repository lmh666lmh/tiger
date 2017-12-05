<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href="<%=basePath%>">
    
    <title>我的订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
    <link rel='stylesheet' href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/xq.css">
    <link rel="stylesheet" type="text/css" href="css/fore/style.css">
    <script src='http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js'></script>
    <script src='http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
    <script type="text/javascript">

    $(function () {
		$("#btn_submit").click(function () {
			var text=$("#text").val();
			var nickname=$("#nickname").val();
			alert=(text);
			$("#articleContent").prepend("<h6>我是"+nickname+" "+new Date().toLocaleString()+"</h6><p style='color: blue'> "+text+"  </p>");	
		});
		
		$("#goOrder").click(function(){
		var arr = new Array();
		for(i=0;i<$(".cartProductItemIfSelected").length;i++){
		if($($(".cartProductItemIfSelected")[i]).attr("src")=="img/cartSelected.png"){
		      var pid=$($(".cartProductItemIfSelected")[i]).attr("pid");
		      arr.push(pid);
		}
	}
		window.location.href="/Tiger/order?cmd=showOrder&pidArr="+arr;
		});
		
 	
	});
					function addNum(pid,price,stock) {
						var sum = parseInt($("#productNum" + pid).val());
						if (sum < stock) {
						sum=sum+1;
							$("#productNum" + pid).val(sum);
						} else {
						    $("#productNum" + pid).val(stock);
						}
						$("#productSum"+pid).html("￥"+parseFloat($("#productNum" + pid).val())*price);
						$("#productSum"+pid).attr("value",parseFloat($("#productNum" + pid).val())*price);
						changeNum(pid,price,stock);
						updatetotalPay();
						
					}
					function reduceNum(pid,price,stock) {
						var sum =parseInt($("#productNum" + pid).val());
						if (sum >1) {
						sum=sum-1;
							$("#productNum" + pid).val(sum);
						} else {
						    $("#productNum" + pid).val(1);
						}
						$("#productSum"+pid).html("￥"+parseFloat($("#productNum" + pid).val())*price);
						$("#productSum"+pid).attr("value",parseFloat($("#productNum" + pid).val())*price);
						changeNum(pid,price,stock);
						updatetotalPay();
						
					}
					function changeNum(pid,price,stock){
					  var sum=$("#productNum" + pid).val();
					  if(sum<1){
					       sum=1;
					       $("#productNum" + pid).val(1);
					  }else if(sum>stock){
					       sum=stock;
					       $("#productNum" + pid).val(stock);
					  }
					  	$("#productSum"+pid).html("￥"+parseFloat($("#productNum" + pid).val())*price);
						$("#productSum"+pid).attr("value",parseFloat($("#productNum" + pid).val())*price);
						updatetotalPay();
					  $.get("/Tiger/cart?cmd=updateCart",{pid:pid,num:sum}, 
		function(data, status) {
		});
					}
					function deleteOI(pid) {
			var flag = confirm("确定删除?");
			if (flag) {
				$.get("/Tiger/cart?cmd=deleteCart",{pid:pid}, 
		function(data, status) {
		$("#tr"+pid).remove();
		});
			} else {
			}
		};
		
		function selectProduct(pid){
		if($("#select"+pid).attr("src")=="img/cartNotSelected.png"){
		$("#select"+pid).attr("src","img/cartSelected.png");
            updatetotalPay();
		}else{
		$("#select"+pid).attr("src","img/cartNotSelected.png");
            updatetotalPay();
		}
		};
		//更新totalPay
		
		function updatetotalPay(){
		 var total=0;
		 var totalNum=0;
		for(i=0;i<$(".cartProductItemIfSelected").length;i++){
		if($($(".cartProductItemIfSelected")[i]).attr("src")=="img/cartSelected.png"){
		   total=total+parseFloat($($(".cartProductItemIfSelected")[i]).parent().parent().children("td").eq(4).children().attr("value")); 
		   totalNum=totalNum+parseInt($($(".cartProductItemIfSelected")[i]).parent().parent().children("td").eq(3).children().children("input").attr("value")); 
		}
	}
	    total=total.toFixed(2);
		$("#totalPay").attr("value",total);
		 $("#totalPay").html("￥"+total);
		 $("#totalNum").html(totalNum);
		 if(total!=0){
		 $("#goOrder").attr("disabled",false);
		 $("#goOrder").css("background-color","rgb(196, 0, 0)");
		 }else{
		 $("#goOrder").attr("disabled","disabled");
		 $("#goOrder").css("background-color","#AAAAAA");
		 } 
		}
</script>
    
  </head>
  
  <body>
  <!--设置导航栏 start  -->
     <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#demo-navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/Tiger/home">欢迎光临Tiger网</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="demo-navbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/Tiger/home">Tiger首页</a></li>
        <li ><a href="#">消息</a></li>
        <li ><a href="#">商品分类</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">我的Tiger<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li class="disabled"><a href="#">我的积分</a></li>
            <li><a href="#tab-meng1">我的收藏</a></li>
            <li><a href="#tab-meng2">我的评论</a></li>
            <li><a href="#tab-meng4">礼品券/礼品卡</a></li>
            <li class="divider"></li> 
            <li class="disabled"><a href="#">我的余额</a></li>
            
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">客户服务<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">帮助中心</a></li>
            <li class="disabled"><a href="#">自助退换货</a></li>
            <li><a href="#">联系客服</a></li>
            <li class="divider"></li> 
            <li class="disabled"><a href="#">我要投诉</a></li>
            
          </ul>
        </li>
        <li ><a href="#" data-toggle="modal" data-target="#about">关于</a></li>
      </ul>
        <div class="navbar-right">
        <ul class="nav navbar-nav">
        <li ><a href="#">我的订单</a></li>
        <li ><a href="/Tiger/cart?cmd=showCart">购物车</a></li>
        </ul> 
        </div> 
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="buyPageDiv">
   <div>
    <img alt="pull-right" src="image/logo.png">
    <div class="access"> <img alt="pull-right" src="image/buyflow.png"> </div>
    <div style="clear:both"></div>
   </div>
</div>

<div class="cartDiv">

	
	
	<div class="cartProductList">
		<table class="cartProductTable">
			<thead>
				<tr>
					<th class="selectAndImage">
					<!-- 		<img selectit="false" class="selectAllItem" src="img/cartNotSelected.png">				
					全选 -->
					
					</th>
					<th>商品信息</th>
					<th>单价</th>
					<th>数量</th>
					<th width="120px">金额</th>
					<th class="operation">操作</th>
				</tr>
			</thead>

				<c:forEach items="${plist}" var="p" varStatus="index">
					<tr id="tr${p.ID}" class="cartProductItemTR">
						<td>
							<img pid=${p.ID} id="select${p.ID}" onclick="selectProduct(${p.ID})" class="cartProductItemIfSelected" src="img/cartNotSelected.png">
							<a style="display:none" href="#nowhere"><img src="img/cartSelected.png"></a>
							<img class="cartProductImg"  src="img/productSingle/${imglist[index.count-1]}.jpg">
						</td>
						<td>
							<div class="cartProductLinkOutDiv">
								<a href="Tiger/showproduct?cmd=product&pid=${p.ID}" class="cartProductLink">${p.NAME}</a>
								<div class="cartProductLinkInnerDiv">
									<img src="img/creditcard.png" title="支持信用卡支付">
									<img src="img/7day.png" title="消费者保障服务,承诺7天退货">
									<img src="img/promise.png" title="消费者保障服务,承诺如实描述">
								</div>
							</div>
							
						</td>
						<td>
							<span class="cartProductItemOringalPrice">￥${p.PRICE}</span>
							<span  class="cartProductItemPromotionPrice">￥${p.DISCOUNTPRICE}</span>
							
						</td>
						<td>
						
							<div class="cartProductChangeNumberDiv">
								<span class="hidden orderItemStock " pid="${p.ID}">${p.STOCK}</span>
								<span class="hidden orderItemPromotePrice " pid="${p.ID}">${p.DISCOUNTPRICE}</span>
								<a   class="numberMinus" href="javascript:reduceNum(${p.ID},${p.DISCOUNTPRICE},${p.STOCK})">-</a>
								<input id="productNum${p.ID}" class="orderItemNumberSetting" onchange="changeNum(${p.ID},${p.DISCOUNTPRICE},${p.STOCK})" value="${list[index.count-1].NUM}">
								<a   class="numberPlus" href="javascript:addNum(${p.ID},${p.DISCOUNTPRICE},${p.STOCK})">+</a>
							</div>					
						
						 </td>
						<td >
							<span class="cartProductItemSmallSumPrice" id="productSum${p.ID}" value="${p.DISCOUNTPRICE*list[index.count-1].NUM}">
							￥${p.DISCOUNTPRICE*list[index.count-1].NUM}</span>
						
						</td>
						<td>
							<a class="deleteOrderItem"   href="javascript:deleteOI(${p.ID})">删除</a>
						</td>
					</tr>
				</c:forEach>				
		
		</table>
	</div>
	
	<div class="cartFoot">
		<img selectit="false" class="selectAllItem" src="img/cartNotSelected.png">
		<span>全选</span>
<!-- 		<a href="#">删除</a> -->
		
		<div class="pull-right">
			<span>已选商品 <span class="cartSumNumber" id="totalNum">0</span> 件</span>
			
			<span>合计 (不含运费): </span> 
			<span class="cartSumPrice" id="totalPay" value="0">￥0.00</span>
			<button class="createOrderButton" id="goOrder" disabled="disabled" >结  算</button>
		</div>
		
	</div>
	
</div>

  </body>
</html>
