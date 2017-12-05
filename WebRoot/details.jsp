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
    
    <title>${p.NAME}</title>
    
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
    $(function () {
		$("#btn_submit").click(function () {
			var text=$("#text").val();
			var nickname=$("#nickname").val();
			alert=(text);
			$("#articleContent").prepend("<h6>我是"+nickname+" "+new Date().toLocaleString()+"</h6><p style='color: blue'> "+text+"  </p>");	
		});
 	//切换图片
	$("#product_img ul li").mouseover(function(){
		  var index=$(this).index();
		var img=$("#product_img ul li a img").eq(index).attr("src");
      
		$("#product_img .main_img").attr("src",img);
	});
	});
    function addAmont(stock) {
    	
	   var num=	parseInt(document.getElementById("numberId").value);
	   if(num==stock){
		   document.getElementById("numberId").value=num;
	   }else{
		   document.getElementById("numberId").value=num+1;
	   }
	  
	  
	   
	}
    function delAmont() {
    	 var num=	parseInt(document.getElementById("numberId").value);
    	 if(num==1){
  		   document.getElementById("numberId").value=num;
  	   }else{
  		   document.getElementById("numberId").value=num-1;
  	   }
	}
	function checkNum(stock){
	 var num=document.getElementById("numberId").value;
	 if(num>stock){
	 document.getElementById("numberId").value=stock;
	 alert("购买数量超出库存");
	 }	 
	 if(num<1){
	  document.getElementById("numberId").value=1;
	 }
	}
        function fn(){
     var content=$("#searchContent").val();
     if(content!= "" || content!= null|| content != undefined){
     window.location.href = "/Tiger/showproduct?cmd=search&content="+content;
     }
    }
    function addCart(pid){
     var num=$("#numberId").val();
     window.location.href = "/Tiger/cart?cmd=addCart&pid="+pid+"&num="+num;
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
     <!--  <div id="nav2">
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
     <!--设置书本详情start -->
     <div id="book">
     <!-- <p><a>当当读书>艺术人生>偷影子的人</a></p> -->
       <div class="bookitem" id="book1">        
         <div id="product_img">
				<img class="main_img" src="img/productSingle/${firstId}.jpg" />
				<ul>
        <c:forEach items="${imglist}" var="img">
        <c:if test="${img.TYPE=='single'}">
       <li><a href=""><img src="img/productSingle/${img.ID}.jpg" /></a></li>
       </c:if>
      </c:forEach>
				</ul>
			</div>
       </div>
       
       
        <div class="bookitem" id="book2">
           <h3 >${p.NAME}</h3>
           <h5>${p.TITLE }</h5>
           <div class="bookitem2">
           <span class="mj">满额减</span>&emsp; &emsp;
           <span class="promo_price">
           <em>满</em>
           <i>¥</i>
           300.0
           <em>减</em>
            <i>¥</i>
            50.0
           </span>
           </div><br>
           <div class="bookitem3">
          原价： <span style="text-decoration:line-through;">¥${p.PRICE }</span>
           
           &emsp; &emsp; &emsp;&emsp; &emsp; &emsp;&emsp; &emsp; &emsp;  127人评分(<span id="pf"> 4.9</span>) <br><br>
           售价:<span class="promo_price"> ¥${p.DISCOUNTPRICE}</span>
           <!-- <a>购买纸书</a> -->
           </div><br>
        <div class="productSaleAndReviewNumber">
           <div>
          销量:
         <span class="redColor boldWord">42</span> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
          &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 
          累计评价:
         <span class="redColor boldWord">18</span> 
           </div>
        </div>
        数量:
        <span>
    <input class="amount-input" id="numberId"  min="1" max="${p.STOCK}"   value="1" maxlength="8" title="请输入购买数量" type="number" onchange="checkNum(${p.STOCK})">
       <img alt="卡了" src="image/add.jpg"  class="addAmont" onclick="addAmont(${p.STOCK})">
       <img alt="卡了" src="image/del.jpg"  class="delAmont" onclick="delAmont(${p.STOCK})">
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp; 
    库存:${p.STOCK}件
        </span><br>
           <a href="javascript:addCart(${p.ID})" id="addShowCar">加入购物车 </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <a href="#" id="buy_now">立即购买 </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </div>

     
     </div>
     <!--设置书本详情end  -->
  
     
     
      <!-- 标签页设置  start   放置在container中 继承居中等已经设置好的属性-->
     <div id="tab-list">
     <ul class="nav nav-tabs" role="tablist" >
        <li class="active"><a href="#tab-meng1" role="tab" data-toggle="tab">商品详情 &nbsp;</a></li>
        <li><a href="#tab-meng2" role="tab" data-toggle="tab">&nbsp;&nbsp;&nbsp;&nbsp;规格参数 &nbsp;&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="#tab-meng3" role="tab" data-toggle="tab">评价 &nbsp;</a></li>      
    </ul>
    </div>
 
<div class="tab-content">
  <div class="tab-pane active" id="tab-meng1">
  <div class="row feature">
  
    <div style="text-align: center;">
    <c:forEach items="${imglist}" var="img">
    <c:if test="${img.TYPE=='detail'}">
      <img alt="卡了" src="img/productDetail/${img.ID}.jpg">
      </c:if>
      </c:forEach>
    </div>
</div>
  </div>
  <div class="tab-pane" id="tab-meng2">
    <div class="row feature">
  <div class="col-md-1">
     
      </div>
  <div class="col-md-6">
  
        <p id="biaoti">产品参数</p>
     <c:forEach items="${pvlist}" var="pv" varStatus="index">
   <p>${pv.NAME}:${pv.VALUE}</p>
    </c:forEach>   
     </div>   
    </div> 
  </div>
  <div class="tab-pane" id="tab-meng3">
   <div class="row feature">
    <div class="col-md-7">
        <h6>777楼</h6>
       <p> <textarea id="text" rows="5" cols="100"></textarea></p>
        <input type="text" id="nickname" value="匿名">
        <input type="button" id="btn_submit" value="发布">
        <article id="articleContent">
        <h6>我是xxx,2017/10/22</h6>
        <p style="color: blue"> 我有故事,你有酒吗?  </p>
        <h6>我是xxx,2017/10/24</h6>
        <p style="color: blue"> 我有酒,你有故事吗?  </p>
        </article>
     </div>
     <div class="col-md-5">
     <br>
     <br>
     <br>
     <br>
    <h3><span class="text-muted"> 人生起起落落,既然来了就留下点痕迹吧~</span></h3> 
     </div></div>
    
  </div>
  <div class="tab-pane" id="tab-meng4">
  <div class="row feature">
  <div class="col-md-5">
    <h2 class="feature-head">这是标题<span class="text-muted"> 这是副标题</span>  </h2>
     <p class="lead">看看效果</p>
    </div>
 <div class="col-md-7">
     <img alt="网络出问题了" src="image/鼓浪屿1.jpg">
    </div></div>
    
  </div>
</div>
    
     <!-- 标签页设置  end-->
     
     
      <!--设置弹出框 start  -->
    <div class="modal fade" id="about">
   <div class="modal-dialog">
   <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span> <span class="sr-only">Close</span></button>
    <h3 class="modal-title">想对你说</h3>
    </div>
     <div class="modal-body">
    <p>
    找客服?<br> 想退货?<br>要投诉?<br>不存在的!
    </p>
     </div>
       <div class="modal-footer">
    
    <a href="#" class="btn btn-primary" data-dismiss="modal">了解了</a>
       </div>
         </div>
       </div>
</div>
    <!--设置弹出框 end  -->
    
  </body>
</html>
