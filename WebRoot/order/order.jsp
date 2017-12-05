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
		var sum=0;
		for(i=0;i<$(".orderItemUnitSum").length;i++){
		 sum=sum+parseFloat($($(".orderItemUnitSum")[0]).html());}
		 sum=sum.toFixed(2);
		 $("#totalPay").html("店铺合计(含运费):￥"+sum);
		 $("#totalPayRed").html("￥"+sum);
		 $("#totalPayRed").css("color","red");
		$("#inputtotal").attr("value",sum);
 	
	});
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

 <form action="/Tiger/order?cmd=addOrder&pidArr=${pidArr}" method="post">
   <div>
    <img alt="pull-right" src="image/logo.png">
    <div class="access"> <img alt="pull-right" src="image/buyflow.png"> </div>
    <div style="clear:both"></div>
   </div>
     <div class="address">
		<div class="addressTip">输入收货地址</div>
		<div>
		
			<table class="addressTable">
				<tr>
					<td class="firstColumn">详细地址<span class="redStar">*</span></td>
					
					<td><textarea name="address" placeholder="建议您如实填写详细收货地址，例如接到名称，门牌好吗，楼层和房间号等信息"></textarea></td>
				</tr>
				<tr>
					<td>邮政编码</td>
					<td><input  name="post" placeholder="如果您不清楚邮递区号，请填写000000" type="text"></td>
				</tr>
				<tr>
					<td>收货人姓名<span class="redStar">*</span></td>
					<td><input  name="receiver"  placeholder="长度不超过25个字符" type="text"></td>
				</tr>
				<tr>
					<td>手机号码 <span class="redStar">*</span></td>
					<td><input name="mobile"  placeholder="请输入11位手机号码" type="text"></td>
				</tr>
			</table>			
		</div>
	</div>
	
	<div class="productList">
		<div class="productListTip">确认订单信息</div>
		
		
		<table class="productListTable">
			<thead>
				<tr>
					<th colspan="2" class="productListTableFirstColumn">
						<img class="tmallbuy" src="image/icon/tigerIcon.png">
						<a class="marketLink" href="#nowhere">店铺：Tiger店铺</a>
						<a class="wangwanglink" href="#nowhere"> <span class="wangwangGif"></span> </a>
					</th>
					<th>单价</th>
					<th>数量</th>
					<th>小计</th>
					<th>配送方式</th>
				</tr>
				<tr class="rowborder">
					<td  colspan="2" ></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody class="productListTableTbody">
				<c:forEach items="${plist}" var="p" varStatus="index">
					<tr class="orderItemTR">
						<td class="orderItemFirstTD"><img class="orderItemImg" src="img/productSingle/${imglist[index.count-1]}.jpg"></td>
						<td class="orderItemProductInfo">
						<a  href="foreproduct?pid=90" class="orderItemProductLink">
							${p.NAME }
						</a>
						
						
							<img src="image/icon/creditcard.png" title="支持信用卡支付">
							<img src="image/icon/7day.png" title="消费者保障服务,承诺7天退货">
							<img src="image/icon/promise.png" title="消费者保障服务,承诺如实描述">
						
						</td>
						<td>
						
						<span class="orderItemProductPrice">${p.DISCOUNTPRICE }</span>
						</td>
						<td>
						<span class="orderItemProductNumber">${list[index.count-1].NUM}</span>
						</td>
						<td>￥<span class="orderItemUnitSum">${p.DISCOUNTPRICE*list[index.count-1].NUM}</span></td>
			</c:forEach>	
						<td rowspan="5"  class="orderItemLastTD">
						<label class="orderItemDeliveryLabel">
							<input type="radio" value="" checked="checked">
							普通配送
						</label>
						
						<select class="orderItemDeliverySelect" class="form-control">
							<option>快递 免邮费</option>
						</select>

						</td>
						
						
					</tr>
						
				
			</tbody>
			
		</table>
		<div class="orderItemSumDiv">
			<div class="pull-left">
				<span class="leaveMessageText">给卖家留言:</span>
				
				<span class="leaveMessageTextareaSpan">
					<textarea name="userMessage" class="leaveMessageTextarea" placeholder="请输入想对卖家说的话~"></textarea>
					
				</span>
			</div>
			
			<span class="pull-right" id="totalPay"> </span>
		</div>				
	</div>
	
  <div class="orderItemTotalSumDiv">
		<div class="pull-right"> 
			<span>实付款：</span>
			<span class="orderItemTotalSumSpan" id="totalPayRed" value="" ></span>
			<input type="hidden" value="" name="totalPay" id="inputtotal" >
		</div>
	</div>
	
	<div class="submitOrderDiv">
			<button type="submit" class="submitOrderButton">提交订单</button>
	</div>
  
 </form>
</div>


  </body>
</html>
