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
    
    <title>产品页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
    <link rel='stylesheet' href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/xq.css">
    <script src='http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js'></script>
    <script src='http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
    <script type="text/javascript">
    function fn(){
     var content=$("#searchContent").val();
     if(content!= "" || content!= null|| content != undefined){
     window.location.href = "/Tiger/showproduct?cmd=search&content="+content;
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
        <!-- <li ><a href="#">请登录</a></li>
        <li ><a href="#">免费注册</a></li> -->
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
     <!--设置导航栏end  -->
     <!--设置搜索框start -->
 <div  id="list">
  <div class="item" id="list1">
    <img alt="卡了" src="image/logo.png" class="item1" >
  </div>
  <div class="item" id="list2">  
      <input type="text" id="searchContent" placeholder="Search for..." class="item2">
      <span ><a href="javascript:fn()">搜索</a></span>
  </div>
  <div class="item" id="list3">
    <div class="item3">
  <img alt="卡了" src="image/new_car.png" >
     购物车
    </div>
  </div>
    <div class="item">
  <img alt="卡了" src="img/code.png" >
    </div>
</div><!-- /.row -->
     <!--设置搜索框end -->
     <!--设置列表start -->
<!--       <div id="nav2">
       <div class="k"><a href="#"> 所有宝贝</a></div>
       <ul>
        <li ><a href="#">保暖专区</a></li>
        <li ><a href="#">长衬衫</a></li>
        <li ><a href="#">夹克&风衣</a></li>
        <li ><a href="#">羽绒服</a></li>
        <li ><a href="#">大衣</a></li>
        <li ><a href="#">皮衣</a></li>
        <li ><a href="#">棉服</a></li>
        <li ><a href="#">单西装</a></li>
        <li ><a href="#">长T</a></li>
       </ul>
      </div>   -->
      <hr id="hr">
     <!--设置列表end -->
     <div class="searchResultDiv">
     <c:forEach items="${list}" var="p" varStatus="index">
		<div class="productUnit" price="${p.PRICE}">
			<a href="/Tiger/showproduct?cmd=product&pid=${p.ID}">
				<img class="productImage" src="img/productSingle/${firstIDList[index.count-1]}.jpg">
			</a>
			<span style="text-decoration: line-through; color:#7a7a7a;; font-size:16px;">¥${p.PRICE}</span>
			<span class="productPrice">¥${p.DISCOUNTPRICE}</span>
			<a class="productLink" href="/Tiger/showproduct?cmd=product&pid=${p.ID}">
			 ${p.NAME}
			</a>
			
			<a class="tmallLink" href="/Tiger/showproduct?cmd=product&pid=${p.ID}">Tiger专卖</a>

			<div class="show1 productInfo">
				<span class="monthDeal ">月成交 <span class="productDealNumber">3笔</span></span>
				<span class="productReview">评价<span class="productReviewNumber">5</span></span>
				<span class="wangwang"><img src="img/wangwang.png"></span>
			</div>
			
		</div>
	</c:forEach>
	<c:if test="${empty list}">
		<div class="noMatch">没有满足条件的产品</div>
	</c:if>
     </div>
</body>