<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分类管理</title>
    
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
			$("#addForm").submit(
					function() {
					var name=document.getElementById("name").value;
					var cp=document.getElementById("categoryPic").value;
						if (name== "" || name== null|| name == undefined) {
							alert("分类名称不能为空");
							return false;
						}
						if (cp== "" || cp== null|| cp == undefined) {
							alert("请上传分类图片");
							return false;
						}
						return true;
					});
		});
		function fn1(id,p) {
			var flag = confirm("确定删除?");
			if (flag) {
				window.location.href = "/Tiger/admin?cmd=deleteCategory&deleteId="
						+ id+"&currentPage="+p;
			} else {
			}
		};
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
   <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">分类管理</div>

  <!-- Table -->
  <table class="table table-striped table-bordered table-hover  table-condensed">
    <tr style="background-color: #dff0d8">
   <th width="5%">ID</th>
   <th width="40%">图片</th>
   <th width="15%">分类名称</th>
   <th width="10%">属性管理</th>
   <th width="10%">产品管理</th>
   <th width="10%">编辑</th>
   <th width="10%">删除</th>
   </tr>
   <c:forEach items="${list}" var="category">
   <tr>
   <td>${category.id}</td>
   <td><img src="./img/c${category.id}.jpg" height="40px"></td>
   <td>${category.name}</td>
   <td><a href="/Tiger/property?cId=${category.id}"><span class="glyphicon glyphicon-th-list"></a></td>
   <td><a href="/Tiger/product?cId=${category.id}"><span class="glyphicon glyphicon-shopping-cart"></a></td>
   <td><a href="/Tiger/admin?cmd=showCategory&editId=${category.id}&currentPage=${currentPage}"><span class="glyphicon glyphicon-edit"></span></a></td>
   <td><a href="javascript:fn1(${category.id},${currentPage})"><span class="glyphicon glyphicon-trash"></a></td>
   </tr>
   </c:forEach>
  </table>
</div>
    <nav aria-label="Page navigation" style="text-align: center;">
  <ul class="pagination">
    <li>
      <a href="/Tiger/admin?currentPage=1" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach begin="${pageIndex.beginIndex}" end="${pageIndex.endIndex}" var="index">
    <li class="${currentPage==index?'active':''}"><a href="/Tiger/admin?currentPage=${index}">${index}</a></li>
    </c:forEach>
    <li>
      <a href="/Tiger/admin?currentPage=${pageIndex.endIndex}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
<div class="panel panel-warning addDiv">
	  <div class="panel-heading">新增分类</div>
	  <div class="panel-body">
	    	<form method="post" id="addForm" action="/Tiger/admin?cmd=addCategory" enctype="multipart/form-data">
	    		<table class="addTable">
	    			<tr>
	    				<td>分类名称</td>
	    				<td><input  id="name" name="name" type="text" class="form-control" ></td>
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
  </body>
</html>
