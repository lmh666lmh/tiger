<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>编辑产品属性值</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="./css/admin.css">
<script type="text/javascript" src="./js/jquery_1.9.js"></script>
<script type="text/javascript">

		function update(name,pid,cid,pvid){
		$.get("/Tiger/product?cmd=editProductValue",{  value:$("#pv"+pvid).val(),
		    pvid:pvid,name:name,pid:pid,cid:cid}, 
		function(data, status) {
		});
		}
		function insert(name,pid,cid,inp){
		console.log(inp.value);
		$.get("/Tiger/product?cmd=editProductValue",{  value:inp.value,
		    pvid:null,name:name,pid:pid,cid:cid}, 
		function(data, status) {
		});
		}
	</script>

</head>

<body>
	<div id="top">
		<a href="/Tiger/home"><img id="logo" alt="#" src="img/logo1.png"></a>
		 <a href="/Tiger/admin">Tiger后台</a>
		<a href="/Tiger/admin">分类管理</a> <a href="#">用户管理</a> <a href="#">订单管理</a>
	</div>
	<div id="propertyDiv">
		<div class="breadcrumb">
			<a href="/Tiger/admin">所有分类</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a
				href="/Tiger/product?cId=${c.id}">${c.name}</a>&nbsp;&nbsp;/&nbsp;&nbsp;${pName}&nbsp;&nbsp;/&nbsp;&nbsp;编辑产品属性
		</div>
		<div class="editPVDiv">
			<c:forEach items="${list}" var="pv">
				<div class="eachPV">
					<span class="pvName">${pv.NAME}</span>
					<c:if test="${pv.ID!=null}">
						<span class="pvValue"><input class="pvValue"
							id="pv${pv.ID}" type="text" value="${pv.VALUE}"
							onchange="update('${pv.NAME}',${pv.PID},${c.id},${pv.ID})">
						</span>
					</c:if>
					<c:if test="${pv.ID==null}">
						<span class="pvValue"><input class="pvValue"
							id="pv${pv.ID}" type="text" value="${pv.VALUE}"
							onchange="insert('${pv.NAME}',${pv.PID},${c.id},this)">
						</span>
					</c:if>
				</div>
			</c:forEach>
			<div style="clear:both"></div>
		</div>
</body>
</html>
