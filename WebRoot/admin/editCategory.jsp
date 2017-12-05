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
    
    <title>编辑分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="./css/admin.css">
	<script type="text/javascript" src="./js/jquery_1.9.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#eidtForm").submit(
					function() {
					var name=document.getElementById("name").value;
					var cp=document.getElementById("categoryPic").value;
						if (name== "" || name== null|| name == undefined) {
							alert("分类名称不能为空");
							return false;
						}
						return true;
					});
		});

	</script>
  </head>
  
  <body>
      <div id="top">
   <a href="/Tiger/home"><img id="logo" alt="#" src="img/logo1.png"></a>
   <a href="/Tiger/admin">Tiger后台</a>
   <a href="/Tiger/admin">分类管理</a>
   <a href="/Tiger/admin">用户管理</a>
   <a href="/Tiger/admin">订单管理</a>
   </div>
   <div id="editCategoryDiv">
   <div class="breadcrumb"><a href="/Tiger/admin">所有分类</a>&nbsp;&nbsp;/&nbsp;&nbsp;编辑分类</div>
   <div class="panel panel-warning addDiv">
	  <div class="panel-heading">编辑分类</div>
	  <div class="panel-body">
	    	<form method="post" id="eidtForm" action="/Tiger/admin?cmd=editCategory&id=${c.id}&currentPage=${currentPage}" enctype="multipart/form-data">
	    		<table class="editTable">
	    			<tr>
	    				<td>分类名称</td>
	    				<td><input  id="name" name="name" type="text" class="form-control" value="${c.name}"></td>
	    			</tr>
	    			<tr>
	    				<td>分类图片</td>
	    				<td>
	    					<input id="categoryPic" accept="image/*" type="file" name="filepath" />
	    				</td>
	    			</tr>
	    			<tr class="submitTR">
	    				<td colspan="2" align="center">
	    					<button type="submit" class="btn btn-success">提 交</button>
	    				</td>
	    			</tr>
	    		</table>
	    	</form>
	  </div>
	</div>
	</div>
  </body>
</html>
