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
    
    <title>用户管理</title>
    
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
					var password=document.getElementById("password").value;
					var email=document.getElementById("email").value;
					var address=document.getElementById("address").value;
			
						if (name== "" || name== null|| name == undefined) {
							alert("用户账号不能为空");
							return false;
						}
						if (password== "" || password== null|| password == undefined) {
							alert("密码不能为空");
							return false;
						}
						if (email== "" || email== null|| email == undefined) {
							alert("邮箱不能为空");
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
   <img id="logo" alt="#" src="">
   <a href="/Tiger/admin">Tiger后台</a>
   <a href="/Tiger/admin">分类管理</a>
   <a href="#">用户管理</a>
   <a href="#">订单管理</a>
   </div>
   <div id="propertyDiv">
   <div class="breadcrumb"><a href="/Tiger/admin">所有用户</a>&nbsp;&nbsp;/&nbsp;&nbsp;${c.name}&nbsp;&nbsp;/&nbsp;&nbsp;用户管理</div>
     <!-- Table -->
  <table class="table table-striped table-bordered table-hover  table-condensed">
    <tr style="background-color: #dff0d8">
   <th width="5%">ID</th>
   <th width="20%">用户名</th>
   <th width="20%">密码</th>
   <th width="20%">邮箱</th>
   <th width="30%">收获地址</th>

   </tr>
   <c:forEach items="${list}" var="product" varStatus="index">
   <tr>
   <td>${product.ID}</td>
   <c:if test="${imgList[index.count-1]!=''}">
   <td><img src="./img/productSingle/${imgList[index.count-1]}.jpg" height="40px"></td>
   </c:if>
    <c:if test="${imgList[index.count-1]==''}">
   <td><img src="./img/001.png" height="40px"></td>
   </c:if>
   <td>${user.USERNAME}</td>
   <td>${user.PASSWORD}</td>
   <td>${user.EMAIL}</td>
   <td>$user.ADDRESS}</td>
   <td><a href="/Tiger/product?cmd=showProductImg&pId=${product.ID}"><span class="glyphicon glyphicon-picture"></span></a></td>
   <td><a href="/Tiger/product?cmd=showProductValue&pId=${product.ID}"><span class="glyphicon glyphicon-th-list"></span></a></td>
   <td><a href="/Tiger/product?cmd=showProduct&editId=${product.ID}&currentPage=${currentPage}&c=${product.CID}"><span class="glyphicon glyphicon-edit"></span></a></td>
   <td><a href="javascript:fn1(${property.ID},${currentPage},${property.CID})"><span class="glyphicon glyphicon-trash"></a></td>
   </tr>
   </c:forEach>
  </table>
</div>
    <nav aria-label="Page navigation" style="text-align: center;">
  <ul class="pagination">
    <li>
      <a href="/Tiger/product?cId=${list[0].CID}&currentPage=1" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach begin="${pageIndex.beginIndex}" end="${pageIndex.endIndex}" var="index">
    <li class="${currentPage==index?'active':''}"><a href="/Tiger/product?cId=${list[0].CID}&currentPage=${index}">${index}</a></li>
    </c:forEach>
    <li>
      <a href="/Tiger/product?cId=${list[0].CID}&currentPage=${pageIndex.endIndex}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>

<div class="panel panel-warning addDiv">
		<div class="panel-heading">新增产品</div>
		<div class="panel-body">
			<form method="post" id="addForm" action="/Tiger/product?cmd=addProduct">
				<table class="addTable">
					<tr>
						<td>产品名称</td>
						<td><input id="name" name="name" type="text" 
							class="form-control"></td>
					</tr>
					<tr>
						<td>产品小标题</td>
						<td><input id="title" name="title" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>原价格</td>
						<td><input id="price" value="99.98" name="price" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>优惠价格</td>
						<td><input id="discountPrice"  value="19.98" name="discountPrice" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>库存</td>
						<td><input id="stock"  value="99" name="stock" type="text"
							class="form-control"></td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="cId" value="${c.id}">
							<button type="submit" class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
  </body>
</html>