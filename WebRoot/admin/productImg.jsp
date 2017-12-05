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
    
    <title>产品图片管理</title>
    
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
			$(".addFormSingle").submit(
					function() {
					var fs=document.getElementById("filepathSingle").value;
						if (fs== "" || fs== null|| fs == undefined) {
							alert("请上传图片");
							return false;
						}
						return true;
					});
			$(".addFormDetail").submit(
					function() {
					var fd=document.getElementById("filepathDetail").value;
						if (fd== "" || fd== null|| fd == undefined) {
							alert("请上传图片");
							return false;
						}
						return true;
					});		
		});
		function fn1(id,pid) {
			var flag = confirm("确定删除?");
			if (flag) {
				window.location.href = "/Tiger/product?cmd=deleteProductImg&deleteId="+id+"&pid="+pid;
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
   <div class="breadcrumb"><a href="/Tiger/admin">所有分类</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a href="product?cId=${c.id }">${c.name}</a>&nbsp;&nbsp;/&nbsp;&nbsp;${p.NAME}&nbsp;&nbsp;/&nbsp;&nbsp;产品图片管理</div>
   	<table class="addPictureTable" align="center">
		<tr>
			<td class="addPictureTableTD">
			  <div>
				<div class="panel panel-warning addPictureDiv">
					<div class="panel-heading">新增产品<b class="text-primary"> 单个 </b>图片</div>
					  <div class="panel-body">
					    	<form method="post" class="addFormSingle" action="product?cmd=addProductImg" enctype="multipart/form-data">
					    		<table class="addTable">
					    			<tr>
					    				<td>请选择本地图片 尺寸400X400 为佳</td>
					    			</tr>
					    			<tr>
					    				<td>
					    					<input id="filepathSingle" type="file" name="filepath" />
					    				</td>
					    			</tr>
					    			<tr class="submitTR">
					    				<td align="center">
					    					<input type="hidden" name="type" value="single" />
					    					<input type="hidden" name="pid" value="${p.ID}" />
					    					<button type="submit" class="btn btn-success">提 交</button>
					    				</td>
					    			</tr>
					    		</table>
					    	</form>
					  </div>
				  </div>			  
			  	<table class="table table-striped table-bordered table-hover  table-condensed"> 
					<thead>
						<tr class="success">
							<th>ID</th>
							<th>产品单个图片缩略图</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="pi">
						<c:if test="${pi.TYPE=='single'}">
							<tr>
								<td>${pi.ID}</td>
								<td>
								<a title="点击查看原图" href="img/productSingle/${pi.ID}.jpg"><img height="50px" src="./img/productSingle/${pi.ID}.jpg"></a>	
								</td>
								<td><a deleteLink="true"
									href="javascript:fn1(${pi.ID},${pi.PID})"><span
										class=" 	glyphicon glyphicon-trash"></span></a></td>
		
							</tr>
						</c:if>
						</c:forEach>
					</tbody>	  
				</table>	
						
			  </div>			
			</td>
			<td class="addPictureTableTD">
			  <div>
			  	
				<div class="panel panel-warning addPictureDiv">
					<div class="panel-heading">新增产品<b class="text-primary"> 详情 </b>图片</div>
					  <div class="panel-body">
					    	<form method="post" class="addFormDetail" action="product?cmd=addProductImg" enctype="multipart/form-data">
					    		<table class="addTable">
					    			<tr>
					    				<td>请选择本地图片 宽度790  为佳</td>
					    			</tr>
					    			<tr>
					    				<td>
					    					<input id="filepathDetail"  type="file" name="filepath" />
					    				</td>
					    			</tr>
					    			<tr class="submitTR">
					    				<td align="center">
					    					<input type="hidden" name="type" value="detail" />
					    					<input type="hidden" name="pid" value="${p.ID}" />
					    					<button type="submit" class="btn btn-success">提 交</button>
					    				</td>
					    			</tr>
					    		</table>
					    	</form>
					  </div>
				  </div>
				  <table class="table table-striped table-bordered table-hover  table-condensed"> 
						<thead>
							<tr class="success">
								<th>ID</th>
								<th>产品详情图片缩略图</th>
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="pi">
							<c:if test="${pi.TYPE=='detail' }">
								<tr>
									<td>${pi.ID}</td>
									<td>
										<a title="点击查看原图" href="img/productDetail/${pi.ID}.jpg"><img height="50px" src="./img/productDetail/${pi.ID}.jpg"></a>
									</td>
									<td><a deleteLink="true"
										href="javascript:fn1(${pi.ID},${pi.PID})"><span
											class=" 	glyphicon glyphicon-trash"></span></a></td>
			
								</tr>
							</c:if>	
							</c:forEach>
						</tbody>	  
					</table>					  		
			  </div>			
			</td>
		</tr>
	</table>

	
	

	
</div>
  </body>
</html>
