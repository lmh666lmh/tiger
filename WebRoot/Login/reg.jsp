<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>


<head>
<base href="<%=basePath%>">

<title>注册界面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<script type="text/javascript"  src="../Tiger/js/jquery.min.js">
</script>
<script type="text/javascript" src="../Tiger/js/register.js"></script>
<link rel="stylesheet" type="text/css"
	href="../Tiger/css/clicki.loginandreg.css" media="screen" />
	

</head>

<body>
	<div class="theCenterBox" >

		<div class="theLoginBox" style="width:657px">
			<div class="loginTxt">注册账号</div>
			<form id="registForm" action="/Tiger/register" method="post">
				<div class="theLoginArea" id="loginBox">
					<p  style="display:inline-block;position: relative;">
						<label class="tdText">邮箱：</label> 
	<input class="inputClass" placeholder="请输入您的邮箱" name="email" id="email" maxlength="255" />
					</p>
			<div class="tdError">
				<label  class="errorClass" id="emailError"></label>
			</div>

					<p style="display:inline-block;position: relative;">

			<label class="tdText">用戶名：</label>
            <input class="inputClass"
			placeholder="请输入您的账号" name="username" id="username"
			maxlength="16" />
							
					</p>
					<div class="tdError">
					<label  class="errorClass"  id="usernameError"></label>
                    </div>


					<p style="position: relative;">
			<label class="tdText">密码：</label>
		    <input class="inputClass"
			placeholder="请输入您的密码" name="password" id="password"
			type="password"  maxlength="16" />
					</p>
					<div class="tdError">
					<label class="errorClass" id="passwordError"></label>
                    </div>
					<p style="position: relative;">
						<label class="tdText">确认密码：</label>
			 <input class="inputClass"
			placeholder="请再次输入您的密码" name="reloginpass" id="reloginpass"
			type="password"  maxlength="16" />
					</p>
					<div class="tdError">
					<label  class="errorClass" id="reloginpassError"></label>
                    </div>
					<p style="position: relative;">
						<label style="display:block;" class="tdText">验证码：</label> 
						<input class="inputClass"  style="display:inline-block;width:70px;"	type="text" name="verifyCode" id="verifyCode">
							<label style=" display: inline-block;" id="divVerifyCode" align="center"><img  id="imgVerifyCode" src="VerifyCode"></label>
			        <label id="changecodeLabel" style=" display: inline-block;"><a id="Changecode" href="javascript:_hyz()">看不清楚，换一张</a></label>
				</p>
			<div class="tdError">
					<label  class="errorClass" id="verifyCodeError"></label>
                </div>


	
			
					<div class="logineg_submit">
					<button id="submitBtn">注册</button>
					</div>
					
					
					</from>
				</div>
		</div>



	</div>
	</div>

	<!--  -	<script>
			function validAll() {
  var span1 = document.getElementById("nameerror");
				var span2 = document.getElementById("passerror");
			var span3 = document.getElementById("emailerror");
				if(span1.style.display == 'block') span1.style.display = 'none';
				else span1.style.display = 'block';
				if(span2.style.display == 'block') span2.style.display = 'none';
				else span2.style.display = 'block';
				if(span3.style.display == 'block') span3.style.display = 'none';
				else span3.style.display = 'block';
				


				var myReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/
					var te = document.getElementById("email")
				var th = document.getElementById("username")
					var td = document.getElementById("password")
				var result = true;
				if(!myReg.test(te.value)) {
document.getElementById("emailerror").innerHTML  = "邮箱格式不对!";
result= false;
				} else {document.getElementById("emailerror").innerHTML = ""
				}


				var regName = /^[a-zA-Z]\w{6,19}$/
			

				
				if(!regName.test(th.value)) {
					document.getElementById("nameerror").innerHTML = "不能以数字开头，只能是字母和数字，大于6位小于20位"
					result = false;
				} else {
					document.getElementById("nameerror").innerHTML = ""
				}

				var regPass = /^\w{8,}$/
	        
				if(!regPass.test(td.value)) {
					document.getElementById("passerror").innerHTML = "只能是字母和数字，大于8位"
					result = false;
				} else {
					document.getElementById("passerror").innerHTML = ""
				}

				return result;
			}
			
			 
		</script>   -->
</body>
</html>
