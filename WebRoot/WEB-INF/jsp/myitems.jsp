<%@ page language="java" import="java.util.*,cn.itcast.ssm.pojo.User,cn.itcast.ssm.pojo.Book" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>您的订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		#box{
			margin:0 auto;
			width:70%;
		}
		#box #show{
			width:90%;
			height:122px;
			border:1px solid #E5E5E5;
			margin:0 auto;
			margin-top:15px;
			margin-bottom:15px;
			position:relative;
		}
		#box #show #top{
			width:100%;
			height:33px;
			background:#F5F5F5;
			position:relative;
			
		}
		#box #show #top span{
			display:block;
			font-size:12px;
			position:absolute;
			left:100px;
			top:10px;
			color:rgb(170,170,170);
		}
		#box #show #block{
			float:left;
			height:62px;
			margin-top:16px;
			margin-left:16px;
		}
		
		 #box #show #image{
		 	width:62px;
		 	
		 	border:1px solid #EFEFEF;
		 	
		 	margin-left:16px;
		 	position:relative;
		 }
		 #box #show .block1{
		 	width:20%;
		 	margin-top:16px;
		 	
		 }
		 #box #show .block1 span{
		 	display:block;
		 	color:rgb(51,51,51);
		 	font-size:16px;
		 }
		 #box #show .block2{
		 	width:20%;
		 	height:62px;
		/* 	border:1px solid red;*/
		 	margin-top:16px;
		 	margin-left:16px;
		 }
		 #box #show .block2 span{
		 	color:#AFAAAC;
		 	font-size:20px;
		 }
		 #box #show .block3{
		 	width:20%;
		 	border:1px solid #E5E5E5;
		 }
		 #box #show .block3 div{
		 	width:100%;
		 	height:50%;
		 }
		
		 #box #show .block3 div span{
		 	display:block;
		 	font-size:14px;
		 	text-align: center;
		 	line-height: 31px;
		 	color:#aaa;
		 }
		 #box #show .block4{
		 	width:20%;
		 	border:1px solid #E5E5E5;
		 }
		 #box #show .block4 span{
		 	display:block;
		 	font-size:14px;
		 	text-align: center;
		 	line-height: 31px;
		 	color:#aaa;
		 }
		 #list{
		 	width:40%;
		 	height:100px;
		 	margin:0 auto;
	
		 }
		 #list div{
		 	float:left;
		 	width:20%;
		 	height:30px;	 
		 	margin-top:50px;
			background:#C40000;
			margin-left:8%;
		 }
		 #list div span a{
		 	display:block;
		 	color:#F0EFFF;
		 	font-size:17px;
		 	font-weight: bold;
		 	text-decoration:none;
		 	text-align: center;
		 	line-height: 30px;
		 }
	</style>
		
	<script type="text/javascript">
		
	</script>
  </head>
  <body>
  	<div id="list">
  		<div id="btn1"><span><a href="${pageContext.request.contextPath }/getAllBook.action">继续购物</a></span></div>
  		<div id="btn2"><span><a href="${pageContext.request.contextPath }/findShopCart.action?userid=${sessionScope.u.id}">查看购物车</a></span></div>
  		<div id="btn3"><span><a href="${pageContext.request.contextPath }">首页</a></span></div>
  	</div>
	  
	 
	  
	  <hr/>
	  <div id="box">
	  	<c:forEach items="${myItemList}" var="item">
	  		<div id="show">
	  			<div id="top"><span>编号：${item.bookId}</span></div>
	  			<div class="block0" id="block"><img id="image" src="image/${item.bookId }.jpg"/></div>
	  			<div class="block1" id="block">
	  				<span>《${item.bookName}》</span>
	  			</div>
	  			<div class="block2" id="block">
	  				<span>x${item.bookNum }</span>
	  			</div>
	  			<div class="block3" id="block">
	  				<div id="one"><span>总额￥${item.bookPrice}</span></div>
	  				<div id="two"><span>货到付款</span></div>
	  			</div>
	  			<div class="block4" id="block">
	  				<span>订单状态：${item.status==0?'待发货':'发货'}</span>
	  			</div>
	  			<div class="block5" id="block"></div>
	  			<div class="block6" id="block"></div>
	  		</div>
	  	</c:forEach>
	  </div>

  </body>
</html>
<!--
<table width="80%">
  	 	<tr>
  	 		<td>图片</td>
  	 		<td>书编号</td>
  	 		<td>书名</td>
  	 		<td>数量</td>
  	 		<td>价钱</td>
  	 		<td>状态</td>
  	 	</tr>
  	 	<c:forEach items="${myItemList}" var="item">
  	 	<tr>
  	 		<td><img id="pic" src="image/${item.bookId }.jpg"/></td>
  	 		<td>${item.bookId}</td>
  	 		<td>《${item.bookName}》</td>
  	 		<td>${item.bookNum }</td>
  	 		<td>${item.bookPrice}</td>
  	 		<td>${item.status==0?'待发货':'发货'}</td>
  	 	</tr>
  	 	</c:forEach>
  	 </table>
  	 
 -->
