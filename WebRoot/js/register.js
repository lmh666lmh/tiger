/*alert(11111);*/

//输入框的校验实现
$(function(){
	$(".errorClass").each(function(){
		showError($(this));
	});
	$("#submitBtn").hover(//切换图片
	function(){
		$("#submitBtn").attr("src","img/regist1.jpg")
		},
	function(){
		$("#submitBtn").attr("src","img/regist2.jpg");
	});
	$(".inputClass").focus(function(){//得到焦点隐藏
		var labelId=$(this).attr("id")+"Error";
		$("#"+labelId).text("");
		showError($("#"+labelId));
	});
	$(".inputClass").blur(function(){
		var id=($(this).attr("id"));
//截取第一个字母并返回大写    如srting=“hello”  提取H并返回Hello
		var funName="validate"+id.substring(0,1).toUpperCase()+id.substring(1)+"()";
		eval(funName);
	});
	//按钮提交（错误不能提交）
	$("#submitBtn").submit(function(){
		var bool=true;
		if(!validateusername()){bool=false;}
		if(!validatepassword()){bool=false;}
		if(!validateReloginpass()){bool=false;}
		if(!validateEmail()){bool=false;}
		if(!validateVerifyCode()){bool=false;}
		
		return bool;
	});
});
//登录名校验
function validateUsername(){
	var id="username";
	var value=$("#"+id).val();
	var regName = /^[a-zA-Z]\w{6,19}$/;
	if(!value){
		$("#"+id+"Error").text("用户名不能为空");
		showError($("#"+id+"Error"));
		return false;
	}else if(!regName.test(value)) {	
		$("#"+id+"Error").text("不能以数字开头，长度6~20位");
		showError($("#"+id+"Error"));
		return false;
	}
	$.ajax({
		url:"NameExistServlet",
		data:{method:"username",val:value},
		async:true,
		cache:false,
		type:"post",
		datatype:"json",
		error:function(){
			alert("name error");
		},
		success:function(result){
			if(result){
				$("#"+id+"Error").text("该用户名已存在");
				showError($("#"+id+"Error"));
				return false;
			}
		}
	})
	return true;
}

//登录密码校验
function validatePassword(){
	var id="password";
	var value=$("#"+id).val();
	var regPass1 = /^\w{8,}$/;
	if(!value){
		$("#"+id+"Error").text("登录密码不能为空");
		showError($("#"+id+"Error"));
		return false;
	}
	if(!regPass1.test(value)) {
		$("#"+id+"Error").text("只能是字母和数字，必须大于8位");
		showError($("#"+id+"Error"));
		return false;
	}
	return true;
}
//登录密码确认校验
function validateReloginpass(){
	var id="reloginpass";
	var value=$("#"+id).val();
	var regPass2 = /^\w{8,}$/;
	if(!value){
		$("#"+id+"Error").text("登录确认密码不能为空");
		showError($("#"+id+"Error"));
		return false;
	}
	if(!regPass2.test(value)) {
		$("#"+id+"Error").text("字母和数字组成，必须大于8位");
		showError($("#"+id+"Error"));
		return false;
	}
	if(value!=$("#password").val()){
		$("#"+id+"Error").text("两次密码不同");
		showError($("#"+id+"Error"));
		return false;
	}
	return true;
}

//Email验证
function validateEmail(){
	var id="email";
	var value=$("#"+id).val();
	if(!value){
		$("#"+id+"Error").text("Email不能为空");
		showError($("#"+id+"Error"));
		return false;
	}
	if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(value)){
		$("#"+id+"Error").text("邮箱格式不对");
		showError($("#"+id+"Error"));
		return false;
	}
	return true;
}

//图形验证码
function validateVerifyCode(){
	var id="verifyCode";
	var value=$("#"+id).val();
	if(!value){
		$("#"+id+"Error").text("验证码不能为空");
		showError($("#"+id+"Error"));
		return false;
	}
	if(value.length!=4){
		$("#"+id+"Error").text("验证码长度必须为4");
		showError($("#"+id+"Error"));
		return false;
	}
	$.ajax({
		url:"UserServlet",
		data:{method:"ajaxValidateVerifyCode",verifyCode:value},
		type:"POST",
		dataType:"json",
		async:true,
		cache:false,
		error:function(){
			alert("false");
		},
		success:function(result){
			if(!result){
			$("#"+id+"Error").text("验证码有误");
			showError($("#"+id+"Error"));
			return false;
			}
		}
	});
	return true;
}

function showError(ele){//显示错误
	var text=ele.text();
	if(!text){
		ele.css("display","none");
	}else{
		ele.css("display","");
	}
}
//换一张验证码
function _hyz(){
	document.getElementById("imgVerifyCode").src = document  
    .getElementById("imgVerifyCode").src  
    + "?nocache=" + new Date().getTime();  
}







