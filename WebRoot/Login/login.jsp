<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0"> 
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
	</script>
	<script type="text/javascript" src="../Tiger/js/login.js"></script>
	<title>登录界面</title>
    <link href="css/default.css" rel="stylesheet" type="text/css" />
	<!--必要样式-->
    <link href="css/styles.css" rel="stylesheet" type="text/css" />
    <link href="css/demo.css" rel="stylesheet" type="text/css" />
    <link href="css/loaders.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form action="/Tiger/login" method="post">
	<div class='login'>
	  <div class='login_title'>
	    <span>用户登录</span>
	  </div>
	  <div class='login_fields'>
	    <div class='login_fields__user'>
	      <div class='icon'>
	        <img alt="" src='img/user_icon_copy.png'>
	      </div>
	      
	      
	      
	     
	      <input name="username"   style="width:250px;" placeholder='用户名' maxlength="16" type='text' autocomplete="off" />
	        <div class='validation'>
	          <img alt="" src='img/tick.png'>
	        </div>
	    </div>
	    <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='img/lock_icon_copy.png'>
	      </div>
	      <input name="password"  style="width:250px;" placeholder='密码' maxlength="16" type='password' autocomplete="off">
	      <div class='validation'>
	        <img alt="" src='img/tick.png'>
	      </div>
	    </div>
	    <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='img/key.png'>
	      </div>
	      <input  placeholder='验证码'  maxlength="4" type='text' name="verifyCode" id="verifyCode" autocomplete="off">
	      <div class='validation' style="opacity: 1; right: 110px;top: -3px;">
         <label style=" display: inline-block;" id="divVerifyCode" align="center"><img  id="imgVerifyCode" src="VerifyCode"></label>
        
	      </div>
	     <label id="changecodeLabel" style=" display: inline-block;"><a id="Changecode" href="javascript:_hyz()">看不清楚，换一张</a></label>
	    </div>
	   <label id="verifyCodeError" style="width:200px;height: 20px;"></label>
	    <div class='login_fields__submit'>
	      <!-- <input type='button'  id="btn" value='登录'> -->
	      <input type="submit" id="btn" value='登录'>
	    </div>
	   
	  </div>
	 </form>
	  <div class='success'>
	  </div>
	  <div class='disclaimer'>
	    <p>欢迎来到Tiger网<a href="/Tiger/home" >返回</a></p>
	  </div>
	</div>
	<div class='authent'>
	  <div class="loader" style="height: 44px;width: 44px;margin-left: 28px;">
        <div class="loader-inner ball-clip-rotate-multiple">
            <div></div>
            <div></div>
            <div></div>
        </div>
        </div>
	  <p>认证中...</p>
	</div>
	<div class="OverWindows"></div>
	
  
	
	</body>
</html>
