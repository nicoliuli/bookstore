<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台订单列表</title>
    
	<meta charset="utf-8">
	
	<style type="text/css">
		#pic{
			width:100px;
		}
	</style>
	<script>
	
	</script>
  </head>
  
  <body>
  <a href="${pageContext.request.contextPath }">首页</a>
 	<hr/>
  	所有订单：<br/>
  	<table width="80%">
  		<tr>
  			<td>图片</td>
  			<td>书号</td>
  			<td>书名</td>
  			<td>个数</td>
  			<td>价钱</td>
  			<td>状态</td>
  			<td>发货</td>
  		</tr>
  		<c:forEach items="${itemList}" var="item">
  			<tr>
  				<td><img id="pic" src="image/${item.bookId }.jpg"/></td>
	  	 		<td>${item.bookId}</td>
	  	 		<td>《${item.bookName}》</td>
	  	 		<td>${item.bookNum }</td>
	  	 		<td>${item.bookPrice}</td>
	  	 		<td>${item.status==0?'待发货':'发货'}</td>
	  	 		<td><a href="${pageContext.request.contextPath}/chstatus.action?userId=${item.userId}&bookId=${item.bookId}">发货</a></td>
  			</tr>
  		</c:forEach>
  		
  	</table>
  </body>
</html>
