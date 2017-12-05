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
    
    <title>My JSP 'shopping.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/shopping.css">
  	<script type="text/javascript" src="js/jquery_1.9.js"></script>
  	<script type="text/javascript" src="js/shopping.js"></script>
  </head>
  
  <body>
  	<!-- 网页整体框架 -->
	<div id="entirety">
		<!-- logo部分 -->
		<div id="top">
			
		</div>
		
		<!-- 购物车 -->
		<div id="centre">
			<!-- 上部分总价 -->
			<div class="sabove">
				已选商品（不含运费）
				<span class="">
					￥1,819.30
				</span>
				<a href="servlet路径" class="atype" >结算</a>
			</div>
			<!-- 表格内容  -->
			<div class="stable">
				<table>
					<tr>
						<th>
							<input type="checkbox" id="checkAll" onclick="checkAll()">
						</th>
						<th>全选</th>
						<th>商品信息</th>
						<th>单价</th>
						<th>数量</th>
						<th>金额</th>
						<th>操作</th>
					</tr>
						<c:forEach items="${sho }" var="shopping" varStatus="AA">
							<tr class="trloc" style="background-color: ${AA.count%2==0?'':'pink' }">
								<td class="td1">
									<input type="hidden" value="${shopping.ID }"><!-- 隐藏域 -->
									<input type="checkbox" class="chinp" id="checksingle">
								</td>
								<td class="td2">
									
									<img alt="商品图" src="img/sing1.jpg">
									
								</td>
								<td class="td3">${shopping.TITLE }</td>
								<td class="td4">
								<span class="">
										${shopping.PRICE }<!-- 价格 -->
									</span>
								</td>
								<td class="td5">
									<a >-</a>
									<input type="text" class="teinp" value="${shopping.NUM}" id="numChange">
									<a>+</a>
								</td>
								<td class="td6">
									<span>
										${shopping.PRICE*shopping.NUM}
									</span>
								</td>
								<td class="td7">
									<a href="/Tiger/shopp?cmd=proDelete&proid=${shopping.ID }" class="">删除</a>
								</td>
							</tr>
						</c:forEach>
						
				</table>
			</div>
			<!-- 下部分总价 -->
			<div class="sbelow">
				<div class="leftsbe">
					<input type="checkbox">
					全选
				</div>
				<div class="rightsbe">
					已选商品
					1
					件
					合计(不含运费)：
					<span class="zongjia">￥1888.0</span>
					<a href="servlet路径" class="atype">结算</a>
				</div>
			</div>
		</div>
		<!-- 底部资料 -->
		<div id="bottom">
		
		</div>
	</div>
  </body>
</html>
