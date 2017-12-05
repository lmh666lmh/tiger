<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<div class="payedDiv">
	<div class="payedTextDiv">
		<img src="image/icon/paySuccess.png">
		<span>您已成功付款</span> 
		
	</div>
	<div class="payedAddressInfo">
		<ul>
			<li>收货地址：一天 43 43</li>
			<li>实付款：<span class="payedInfoPrice">
			￥3,824.16
			</li>
			<li>预计08月08日送达	</li>
		</ul>
				
		<div class="paedCheckLinkDiv">
			您可以
			<a class="payedCheckLink" href="forebought">查看已买到的宝贝</a>
			<a class="payedCheckLink" href="forebought">查看交易详情 </a>
		</div>
			
	</div>
	
	<div class="payedSeperateLine">
	</div>
	
	<div class="warningDiv">
		<img src="image/icon/warning.png">
		<b>安全提醒：</b>下单后，<span class="redColor boldWord">用QQ给您发送链接办理退款的都是骗子！</span>Tiger不存在系统升级，订单异常等问题，谨防假冒客服电话诈骗！
	</div>

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
    
  </body>
</html>
