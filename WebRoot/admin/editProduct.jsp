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
    
    <title>编辑产品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="./css/admin.css">
	<script type="text/javascript" src="./js/jquery_1.9.js"></script>
	<script type="text/javascript">

	</script>

  </head>
  
  <body>
     <div id="top">
   <a href="/Tiger/home"><img id="logo" alt="#" src="img/logo1.png"></a>
   <a href="/Tiger/admin">Tiger后台</a>
   <a href="/Tiger/admin">分类管理</a>
   <a href="#">用户管理</a>
   <a href="#">订单管理</a>
   </div>
   <div id="propertyDiv">
   <div class="breadcrumb"><a href="/Tiger/admin">所有分类</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a href="/Tiger/product?cId=${p.CID}">${c.name}</a>&nbsp;&nbsp;/&nbsp;&nbsp;${p.NAME}&nbsp;&nbsp;/&nbsp;&nbsp;编辑产品</div>
   <div class="panel panel-warning editDiv">
		<div class="panel-heading">编辑产品</div>
		<div class="panel-body">
			<form method="post" id="editForm" action="/Tiger/product?cmd=editProduct&currentPage=${currentPage }">
				<table class="editTable">
					<tr>
						<td>产品名称</td>
						<td><input id="name" name="name" value="${p.NAME}"
							type="text" class="form-control"></td>
					</tr>
					<tr>
						<td>产品标题</td>
						<td><input id="title" name="title" type="text"
						value="${p.TITLE}"
							class="form-control"></td>
					</tr>
					<tr>
						<td>原价格</td>
						<td><input id="Price" value="${p.PRICE}" name="price" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>优惠价格</td>
						<td><input id="discountprice"  value="${p.DISCOUNTPRICE}" name="discountprice" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>库存</td>
						<td><input id="stock"  value="${p.STOCK}" name="stock" type="text"
							class="form-control"></td>
					</tr>
										
					<tr class="submitTR">
						<td colspan="2" align="center">
						<input type="hidden" name="id" value="${p.ID}">
						<input type="hidden" name="cid" value="${p.CID}">
						<button type="submit" class="btn btn-success">提 交</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
  </body>
</html>
