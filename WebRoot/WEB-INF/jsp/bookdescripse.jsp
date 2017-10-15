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
    
    <title>图书详细信息</title>
    
	<meta charset="utf-8">
	<style type="text/css">
		
		#header{
			width: 100%;
			height: 90px;
			border-bottom: 1px solid #BDBDBD;
		}
		#header #logo{
			width: 100px;
			float: left;
		}
		#header #logo img{
			width: 100%;
		}
		#header #search{
			float: left;
			margin-left: 70px;
		}
		#header #search span{
			display: block;
			float: left;
			width: 84px;
			height: 35px;
			margin-top: 15px;
			border: 1px solid #BDBDBD;
			border-right: none;
			font-family: arial,sans-serif;
			font-weight: normal;
			line-height: 35px;
			color:#777777;
			text-align: center;
			font-size: 13.3px;
		}
		#header #search #text{
			border: 1px solid #BDBDBD;
			width: 1195px;
			height: 33px;
			margin-top: 15px;
			text-indent: 5px;
		}
		#header #search #submit{
			margin-top: 15px;
			margin-left: 0px;
			height: 35px;
			border: 1px solid #BDBDBD;
		}
		#header #seeShopcart{
			width:100px;
			height:35px;
			background:#C40000;
			float:left;
			margin-top:15px;
			margin-left:5px;
		}
		#header #seeShopcart a{
			color:#ffffff;
			font-family: "微软雅黑";
			font-size:16px;
			line-height: 41px;
			text-align: center;
			display:block;
			text-decoration: none;
		}
		#header #seeAllBook{
			width:100px;
			height:35px;
			background:#C40000;
			float:left;
			margin-top:15px;
			margin-left:5px;
		}
		#header #seeAllBook a{
			color:#ffffff;
			font-family: "微软雅黑";
			font-size:16px;
			line-height: 41px;
			text-align: center;
			display:block;
			text-decoration: none;
		}
		#box{
			width:1200px;
			margin:0 auto;
			margin-top:20px;
		}
		#box .show{
			width:250px;
			height:390px;
			float:left;
			border:1px solid #EDEDED;
			margin-right:20px;
			margin-bottom:20px;
		}
		#box .show .showImg{
			width:100%;
			height:250px;
		}
		#box .show .showImg img{
			width:100%;
			margin:0 auto;
		}
		#box .show .showOther{
			position:relative;
			width:100%;
		}
		#box .show .showOther #p1{
			position:absolute;
			left:10px;
			top:0px;
			font-size:18px;
			color:#f40;
			font-weight:700;
			float:left;
		
		}
		#box .show .showOther #p2{
			position:absolute;
			right:20px;
			top:0px;
		}
		#box .show .showOther #p3{
			position:absolute;
			left:15px;
			top:30px;
		}
		#box .show .showOther #p4{
			position:absolute;
			left:15px;
			top:58px;
		}
		#box .show .showOther a{
			position:absolute;
			left:15px;
			top:100px;
			color:#888888;
			text-decoration: none;
		}
		#box .show .showOther a:hover{
			color:#FF4400;
			text-decoration: underline;
		}
		#footer{
			width:100%;
		}
		#footer div{
			width:1193px;
			margin:0 auto;
		}
	</style>
	<script type="text/javascript">
		window.onload = function(){
			var shows = document.getElementsByClassName('show');
			for(var i = 0;i<shows.length;i++){
				shows[i].onmouseover = function(e){
					e = e || window.event;//事件对象
					var target = e.target || e.srcElement//事件源对象
					target.style.border = "1px solid #F8855B";
					
				}
				shows[i].onmouseout = function(e){
					e = e || window.event;//事件对象
					var target = e.target || e.srcElement//事件源对象
					target.style.border = "1px solid #EDEDED";
				}
			}
		}
	</script>
  </head>
  
  <body>
	  <div id="header">
	  		<div id="logo"><img src="indeximg/logo.jpg"></div>
	  		<div id="search">
	  			<form action="/bookstore/findBookByName.action" method="post">
	  				<span>输入书名</span>
	  				<input type="text" name="bookName" id="text">
	  				<input type="submit" value="查找图书" id="submit">
	  			</form>
	  				
	  		</div>
	  			
	  		<!-- 如果用户登录，可以查看购物车 -->
	  		
	  		<c:if test="${u.id != null}">
	  			<div  id="seeShopcart">
	  				<a href="/bookstore/findShopCart.action?userid=${u.id }">查看购物车</a>
	  			</div>
	  		</c:if>
	  		<div id="seeAllBook">
	  			<a href="/bookstore/getAllBook.action">查看所有书</a>
	  		</div>
	  		
	  		
	  	</div>
		<div id="box">
  		<c:forEach items="${bookList}" var="onebook">
  			<div class="show">
  				<div class="showImg"><img src="image/${onebook.id}.jpg"/></div>
  				<div class="showOther">
  					<p id="p1">￥${onebook.price }</p>
  					<p id="p2">作者：${onebook.author }</p>
  					<p id="p3">《${onebook.bookName }》</p>
  					<p id="p4">描述：${onebook.descripse }</p>
  					<a href='/bookstore/addIntoShopCart.action?user_id=${u.id}&book_id=${onebook.id}'>加入购物车</a>
  				</div>
  			</div>
  		</c:forEach>
  	</div>
  	<div id="footer">
  		<div>
  			<img src="indeximg/footer.jpg"/>
  		</div>
  	</div>
  </body>
</html>
