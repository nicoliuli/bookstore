<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>查找的图书的信息不存在</title>
	<meta charset="utf-8">
	<style>
		#box{
			margin:0 auto;
			margin-top:300px;
			height:90px;
			width:500px;
			overflow: hidden;
		}
		#box #pic{
			width:100px;
			float: left;
			
		}
		#box #title{
			height:100%;
		}
		#box #title span{
			line-height: 90px;
		}
		#box #title span a{
			text-decoration: none;
			color:black;
		}
		#box #title span a:hover{
			text-decoration: underline;
			color:#FF7D00;
		}
	</style>
  </head>
  
  <body>
  	<div id="box">
  		<div id="pic">
  			<img src="indeximg/sorry.jpg"/>
  		</div>
  		
  		<div id="title">
  			<span>没有找到与"</span>
	  		<span>${bookName}</span>
	  		<span>"相关的书籍，<a href="/bookstore/getAllBook.action">点击重新查找</a></span>
  		</div>
  		
  	</div>
  	
  	
  </body>
</html>
