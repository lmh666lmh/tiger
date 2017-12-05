
$(function(){
	$("#verifyCode").focus(function(){//得到焦点隐藏
		var labelId=$(this).attr("id")+"Error";
		$("#"+labelId).text("");
		showError($("#"+labelId));
	});
	$("#verifyCode").blur(function(){
		var id=($(this).attr("id"));
//截取第一个字母并返回大写    如srting=“hello”  提取H并返回Hello
		var funName="validate"+id.substring(0,1).toUpperCase()+id.substring(1)+"()";
		eval(funName);
	});
	
	$("#randomCode").blur(function(){
	var username= $("#username").val();
	var password = $("#password").val();
	var randomCode = $("#imgVerifyCode").val();
	var ajax = createAjax();
	ajax.open("post","/login",true);
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200){
			var text =  ajax.respText;
			$("#erro").html(text);
			console.debug(text);
			}
	};
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send("&randomCode="+randomCode);
	});
});

//登录验证



//创建Ajax对象
function createAjax() {
	var ajax;
	try {
		ajax = new XMLHttpRequest();
		
	} catch (e) {
		// : handle exception
		ajax = new ActiveXObject();
		
	}
	return ajax;
}


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
function _hyz(){
	document.getElementById("imgVerifyCode").src = document  
    .getElementById("imgVerifyCode").src  
    + "?nocache=" + new Date().getTime();  
}



