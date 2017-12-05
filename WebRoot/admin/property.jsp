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
    
    <title>属性管理</title>
    
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
						if (name== "" || name== null|| name == undefined) {
							alert("属性名称不能为空");
							return false;
						}
						return true;
					});
		});
				function fn1(id,p,cId) {
			var flag = confirm("确定删除?");
			if (flag) {
				window.location.href = "/Tiger/property?cmd=deleteProperty&deleteId="
						+ id+"&currentPage="+p+"&cId="+cId;
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
   <div id="propertyDiv">
   <div class="breadcrumb"><a href="/Tiger/admin">所有分类</a>&nbsp;&nbsp;/&nbsp;&nbsp;${c.name}&nbsp;&nbsp;/&nbsp;&nbsp;属性管理</div>
     <!-- Table -->
  <table class="table table-striped table-bordered table-hover  table-condensed">
    <tr style="background-color: #dff0d8">
   <th width="10%">ID</th>
   <th width="40%">属性名称</th>
   <th width="25%">编辑</th>
   <th width="25%">删除</th>
   </tr>
   <c:forEach items="${list}" var="property">
   <tr>
   <td>${property.ID}</td>
   <td>${property.name}</td>
   <td><a href="/Tiger/property?cmd=showProperty&editId=${property.ID}&currentPage=${currentPage}&cId=${property.CID}"><span class="glyphicon glyphicon-edit"></span></a></td>
   <td><a href="javascript:fn1(${property.ID},${currentPage},${property.CID})"><span class="glyphicon glyphicon-trash"></a></td>
   </tr>
   </c:forEach>
  </table>
</div>
    <nav aria-label="Page navigation" style="text-align: center;">
  <ul class="pagination">
    <li>
      <a href="/Tiger/property?cId=${list[0].CID}&currentPage=1" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach begin="${pageIndex.beginIndex}" end="${pageIndex.endIndex}" var="index">
    <li class="${currentPage==index?'active':''}"><a href="/Tiger/property?cId=${list[0].CID}&currentPage=${index}">${index}</a></li>
    </c:forEach>
    <li>
      <a href="/Tiger/property?cId=${list[0].CID}&currentPage=${pageIndex.endIndex}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
<div class="panel panel-warning addDiv">
	  <div class="panel-heading">新增属性</div>
	  <div class="panel-body">
	    	<form method="post" id="addForm" action="/Tiger/property?cmd=addProperty&cId=${list[0].CID}" >
	    		<table class="addTable">
	    			<tr>
	    				<td>属性名称</td>
	    				<td><input  id="name" name="name" type="text" class="form-control" ></td>
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
