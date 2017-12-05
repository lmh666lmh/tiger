<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href="<%=basePath%>">
    
    <title>订单管理</title>
    
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
    
    <script>
var deleteOrder = false;
var deleteOrderid = 0;

$(function(){
	$("a[orderStatus]").click(function(){
		var orderStatus = $(this).attr("orderStatus");
		if('all'==orderStatus){
			$("table[orderStatus]").show();	
		}
		else{
			$("table[orderStatus]").hide();
			$("table[orderStatus="+orderStatus+"]").show();			
		}
		
		$("div.orderType div").removeClass("selectedOrderType");
		$(this).parent("div").addClass("selectedOrderType");
	});
	
	$("a.deleteOrderLink").click(function(){
		deleteOrderid = $(this).attr("oid");
		deleteOrder = false;
		$("#deleteConfirmModal").modal("show");
	});
	
	$("button.deleteConfirmButton").click(function(){
		deleteOrder = true;
		$("#deleteConfirmModal").modal('hide');
	});	
	
	$('#deleteConfirmModal').on('hidden.bs.modal', function (e) {
		if(deleteOrder){
			var page="foredeleteOrder";
			$.post(
				    page,
				    {"oid":deleteOrderid},
				    function(result){
						if("success"==result){
							$("table.orderListItemTable[oid="+deleteOrderid+"]").hide();
						}
						else{
							location.href="login.jsp";
						}
				    }
				);
			
		}
	})		
	
	$(".ask2delivery").click(function(){
		var link = $(this).attr("link");
		$(this).hide();
		page = link;
		$.ajax({
			   url: page,
			   success: function(result){
				alert("卖家已秒发，刷新当前页面，即可进行确认收货")
			   }
			});
		
	});
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
      <a class="navbar-brand" href="#">欢迎光临Tiger网</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="demo-navbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Tiger首页</a></li>
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
        <li ><a href="#">购物车</a></li>
        </ul> 
        </div> 
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="buyPageDiv">
   <div>
    <img alt="pull-right" src="image/logo.png">
    <div class="access"> <img alt="pull-right" src="image/payFinish.jpg"> </div>
    <div style="clear:both"></div>
   </div>
</div>
   
   
   <div class="boughtDiv">
	<div class="orderType">
		<div class="selectedOrderType"><a orderStatus="all" href="#nowhere">所有订单</a></div>
		<div><a  orderStatus="waitPay" href="#nowhere">待付款</a></div>
		<div><a  orderStatus="waitDelivery" href="#nowhere">待发货</a></div>
		<div><a  orderStatus="waitConfirm" href="#nowhere">待收货</a></div>
		<div><a  orderStatus="waitReview" href="#nowhere" class="noRightborder">待评价</a></div>
		<div class="orderTypeLastOne"><a class="noRightborder">&nbsp;</a></div>
	</div>
	<div style="clear:both"></div>
	<div class="orderListTitle">
		<table class="orderListTitleTable">
			<tr>
				<td>宝贝</td>
				<td width="140px">单价</td>
				<td width="130px">数量</td>
				<td width="120px">实付款</td>
				<td width="140px">交易操作</td>
			</tr>
		</table>
	
	</div>
	
	<div class="orderListItem">
		
			<table class="orderListItemTable" orderStatus="waitConfirm" oid="4173">
				<tr class="orderListItemFirstTR">
					<td colspan="2">
					<b>2017-11-23 10:22:35</b> 
					<span>订单号: 201711231022353842570 
					</span>
					</td>
					<td  colspan="2"><img width="13px" src="image/icon/tigerIcon.png">Tiger商场</td>
					<td colspan="1">
						<a class="wangwanglink" href="#nowhere">
							<div class="orderItemWangWangGif"></div>
						</a>
						
					</td>
					<td class="orderItemDeleteTD">
						<a class="deleteOrderLink" oid="4173" href="#nowhere">
							<span  class="orderListItemDelete glyphicon glyphicon-trash"></span>
						</a>
						
					</td>
				</tr>
				
					<tr class="orderItemProductInfoPartTR" >
						<td class="orderItemProductInfoPartTD"><img width="80" height="80" src="img/productSingle_middle/492.jpg"></td>
						<td class="orderItemProductInfoPartTD">
							<div class="orderListItemProductLinkOutDiv">
								<a href="foreproduct?pid=150">德国DGPOSY超漩式彩色马桶缓降坐便器静音节水抽水马桶连体座便器</a>
								<div class="orderListItemProductLinkInnerDiv">
											<img src="image/icon/creditcard.png" title="支持信用卡支付">
											<img src="image/icon/7day.png" title="消费者保障服务,承诺7天退货">
											<img src="image/icon/promise.png" title="消费者保障服务,承诺如实描述">						
								</div>
							</div>
						</td>
						<td  class="orderItemProductInfoPartTD" width="100px">
						
							<div class="orderListItemProductOriginalPrice">￥2,399.00</div>
							<div class="orderListItemProductPrice">￥1,799.25</div>
		
		
						</td>
						
						 
							<td valign="top" rowspan="1" class="orderListItemNumberTD orderItemOrderInfoPartTD" width="100px">
								<span class="orderListItemNumber">1</span>
							</td>
							<td valign="top" rowspan="1" width="120px" class="orderListItemProductRealPriceTD orderItemOrderInfoPartTD">
								<div class="orderListItemProductRealPrice">￥1,799.25</div>
								<div class="orderListItemPriceWithTransport">(含运费：￥0.00)</div>
							</td>
							<td valign="top" rowspan="1" class="orderListItemButtonTD orderItemOrderInfoPartTD" width="100px">
								
									<a href="foreconfirmPay?oid=4173">
										<button class="orderListItemConfirm">确认收货</button>
									</a>
								
								
								
								

								
							</td>						
						
					</tr>
						
				
			</table>
			</div>
			
			



<div id="footer"  class="footer" style="display: block;">
	
    <div id="footer_ensure" class="footer_ensure">
            <a href="#nowhere">
            	<img src="image/icon/ensure.png">
            </a>
    </div>

	<div class="horizontal_line">
	</div>
	    
    <div id="footer_desc" class="footer_desc">
            <div class="descColumn">
			    <span class="descColumnTitle">购物指南</span>
			    <a href="#nowhere" >免费注册</a> 
			    <a href="#nowhere" >开通支付宝</a> 
			    <a href="#nowhere" >支付宝充值</a>
			</div>
            <div class="descColumn">
			    <span class="descColumnTitle">Tiger保障</span>
			    <a href="#nowhere" >发票保障</a> 
			    <a href="#nowhere" >售后规则</a> 
			    <a href="#nowhere" >缺货赔付</a>
			</div>
            <div class="descColumn">
			    <span class="descColumnTitle">支付方式</span>
			    <a href="#nowhere" >快捷支付</a> 
			    <a href="#nowhere" >信用卡</a> 
			    <a href="#nowhere" >蚂蚁花呗</a>
			    <a href="#nowhere" >货到付款</a>
			</div>
            <div class="descColumn">
			    <span class="descColumnTitle">商家服务</span>
			    <a href="#nowhere" >商家入驻</a> 
			    <a href="#nowhere" >商家中心</a> 
			    <a href="#nowhere" >Tiger智库</a>
			    <a href="#nowhere" >Tiger规则</a>
			    <a href="#nowhere" >物流服务</a>
			    <a href="#nowhere" >虎言虎语</a>
			    <a href="#nowhere" >运营服务</a>
			</div>
            <div class="descColumn">
			    <span class="descColumnTitle">手机Tiger</span>
			 <div class="phone">  <a href="#" ><img src="image/ewm.png"></a>  </div> 
			</div>		
    </div>
   </div>
  </body>
</html>
