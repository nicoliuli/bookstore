<%@ page language="java" import="java.util.*,cn.itcast.ssm.pojo.User,cn.itcast.ssm.pojo.Book" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
double totalPrice = 0;	//计算购物车的总价

User u = (User)request.getAttribute("user");
List<Book> bookList = null;
if(u != null){
	bookList = u.getBookList();
		if(bookList != null){
			for(Book book:bookList){
				double price = book.getPrice();
				int count = book.getShopCart().getBookNumber();
				totalPrice = totalPrice + price*count;
				
			}
		}
}
pageContext.setAttribute("totalPrice",totalPrice);	//将价钱加入page域，仅在本页面有效

  					
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>您的购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	*{
		padding:0px;
		margin:0px;
	}
	#box{
		width:70%;
		border-top:2px solid #AAA;
		margin:0 auto;
		margin-top:30px;
	}
	#box table{
		width:100%;
	}
	#box table #one img{
		width:82px;
	}
	#box table{
		border-left:1px solid #F1F1F1;
		border-right:1px solid #F1F1F1;
	}
	#box table tr td{
		border-bottom: 1px solid #F1F1F1;
		padding-top:16px;
		padding-bottom: 16px;
	}
	#box table tr #one{
		padding-left:42px;
	}
	#box table tr #three span{
		display:block;
		border:1px solid #aaa;
		text-align: center;
		padding-left:10px;
		padding-right:10px;
		padding-top:5px;
		padding-bottom: 5px;
	}
	#box table tr #three a{
		display:block;
		text-decoration: none;
		text-align: center;
		font-size:20px;
		font-weight: bold;
		color:black;
		border:1px solid #aaa;
	}
	#box table tr #four{
		color:#333;
		font-weight: 400;
		display:block;
		line-hight:20px;
	}
	#box table tr #five a{
		text-decoration: none;
		font-size:14px;
		color:#666666;
	}
	#box table tr #five a:hover{
		color:red;
	}
	#box table tr #six a{
		text-decoration: none;
		font-size:14px;
		color:#666666;
	}
	#box table tr #six a:hover{
		color:red;
	}
	
	#footer{
		margin:0 auto;
		width:55%;
		margin-top:20px;
	}
	#footer img{
		width:100%;
	}
	#header{
		width:70%;
		margin:0 auto;
		height:100px;
	}
	#header #logo{
		width:270px;
		height:60px;
		margin-top:30px;
		margin-bottom:30px;
		float:left;
	}
	#header #search{
		float:left;
		margin-top:50px;
		margin-left:50px;
		
	}
	#header #search form #text{
		width:40%;
		height:30px;
		text-indent: 5px;
	}
	#header #search form #submit{
		width:80px;
		height:30px;
	}
	#header #seeAllBook{
		float:left;
		margin-top:50px;
		margin-left:-30px;
		hight:30px;
		height:30px;
		width:100px;
		background:#C40000;
	}
	#header #seeAllBook a{
		display:block;
		color:white;
		font-weight: bold;
		text-decoration: none;
		text-align: center;
		line-height: 30px;
		
	}
	#header #logout{
		float:left;
		margin-top:50px;
		margin-left:10px;
		hight:30px;
		height:30px;
		width:100px;
		background:#C40000;
	}
	#header #logout a{
		display:block;
		color:white;
		font-weight: bold;
		text-decoration: none;
		text-align: center;
		line-height: 30px;
	}
	</style>
  </head>
  <body>
  	 <div id="header">
	  		<div id="logo">
	  			<a href="${pageContext.request.contextPath }"><img src="indeximg/jd_logo.png"/></a>
	  		</div>
	  		<div id="search">
		  			<form action="/bookstore/findBookByName.action" method="post">
		  				<input type="text" name="bookName" id="text">
		  				<input type="submit" value="搜索" id="submit">
		  			</form>
		  				
		  	</div>
		  	<div id="seeAllBook">
		  		<a href="/bookstore/getAllBook.action">查看所有</a>
		  	</div>
		  	<div id="logout">
		  		<a id="zhuxiao" href="/bookstore/invalidate.action">注销</a>
		  	</div>  	
	  </div>
	
	  	<!-- 头部结束 -->
	 	<div id="box">
	 		<table>
	 			<c:forEach items="${user.bookList}" var="bookList">
	 				<tr>
		 				<td id="one"><img src="image/${bookList.id }.jpg"/></td>
		 				<td id=""two>《${bookList.bookName }》</td>
		 				<td id="three">
		 					<a class="sub" href='/bookstore/bookSubOne.action?user_id=${u.id}&book_id=${bookList.id}'>-</a>
		  					<span>${bookList.shopCart.bookNumber }</span>
		  					<a class="add" href='/bookstore/bookAddOne.action?user_id=${u.id}&book_id=${bookList.id}'>+</a>
		 				</td>
		 				<td id="four">￥${bookList.price}</td>
		 				<td id="five"><a href="/bookstore/deleteBook.action?user_id=${u.id}&book_id=${bookList.id}">删除</a></td>
		 				<td id="six"><a href="/bookstore/upItem.action?userId=${u.id }&bookId=${bookList.id }&bookName=${bookList.bookName }&bookNum=${bookList.shopCart.bookNumber }&bookPrice=${bookList.shopCart.bookNumber* bookList.price}">提交订单</a></td>
	 			
	 				</tr>
	 			</c:forEach>
	 			
	 		</table>
	 	</div>
	  	<!-- 底部开始 -->
	  	<div id="footer">
	  		<img src="indeximg/bottom.jpg"/>
	  	</div>

  </body>
</html>