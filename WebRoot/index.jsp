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
    <title>书店首页</title>
	<meta charset="utf-8" />
	<style type="text/css">
		*{
			padding: 0px;
			margin:0px;
		}
		
		#header{
			width:80%;
			height:150px;
			background:#FAFAFA;
			position:relative;
			margin:0 auto;
		}
		#header #logo{
			width:100px;
			margin:20px;
			float:left;
		}
		#header #logo img{
			width:100%;
		}
		#header #search{
			width:50%;
			float:left;
			margin:20px;
			margin-top:40px;
			margin-left:30px;
		}
		#header #search #text{
			width:70%;
			height:30px;
		}
		#header #search #submit{
			height:30px;
			padding-left:10px;
			padding-right:10px;
		}
		/*******************************/
		#lunbo{
			margin:0 auto;
			width: 1500px;
			height: 300px;
			margin-top: 10px;
		}
		li{
			list-style: none;
		}
		/*box*********************************/
		
		
		#footer{
			width:1500px;
			margin:0 auto;
			margin-top:230px;
		}
		#footer #top{
			width:660px;
			height:230px;
			margin:0 auto;
		}
		#footer #top ul{
			float:left;
			margin-left:30px;
		}
		#footer #top ul li{
			font-family: arial,sans-serif;
    		color: #004B91;
    		font-size:14px;
    		line-height: 120%;
    		margin-bottom:10px;
		}
		#footer #top ul .oneLi{
			font-size:16px;
			color:#333;
			font-family: arial,sans-serif;
			margin-bottom:10px;
		}
		#footer #last{
			
			margin:0 auto;
		}
		#footer #last img{
			display:block;
			margin:0 auto;
		}
		#header #operator{
			float:left;
			margin:20px;
			position:absolute;
			top:35px;
			right:0px;
		}
		#header #operator a{
			display;block;
			text-decoration: none;
			color:black;
		}
		#header #operator a:hover{
			color:red;
		}
		#box{
			margin:0 auto;
			width:1500px;
			height:400px;
	
			position:relative;
			margin-top:30px;
		}
		#box #hot_left{
			position:absolute;
			top:40px;
			left:0px;
		}
		#box p{
			font-size:20px;
		}
		#box #hot_center{
			position:absolute;
			top:40px;
			left:245px;
		}
		#box #hot_center #changebox{
			position:absolute;
			top:0px;
			left:0px;
			width:740px;
			height:360px;
		}
		#box #hot_center #changebox .change{
			float:left;
			width:123px;
			height:93px;
		}
		#box #hot_week{
			width:300px;
			height:380px;
			position:absolute;
			top:40px;
			right:0px;
			background: black;
		}
		#box #hot_week #show{
			width:300px;
			overflow: hidden;	
		}
		#box #hot_week #show ul{
			width:1800px;	
			position: relative;
		}
		#box #hot_week #show ul li{
			float:left;
			list-style: none;
		}
		#box #hot_week #show ul li img{
			width:300px;
		}
		#box #hot_week  #menu{
			width:300px;
			height:80px;
		}
		#box #hot_week  #menu ul li{
			float:left;
			width:50px;
			list-style: none;
		}
		#box #hot_week  #menu ul li img{
			width:50px;
			height:80px;
			opacity:0.5;
		}
	</style>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			var lunbo = document.getElementById('lunbo');
			var lunboImg = document.getElementById('lunboImg');
			var i = 1;
			setInterval(function(){
				lunboImg.src = "indeximg/"+i+".jpg";
				i++;
				if(i > 4){
					i = 1;
				}
			},1000)
			/**/
			$('#box #hot_center #changebox .change').hover(function(){
				
				var index = $(this).index();
				
				$(this).css('background','url(indeximg/hover.jpg)');
			},function(){
				$(this).removeAttr('style');
			})
			
			/*本周热卖*/
			var index = 0;
				$('#box #hot_week #menu ul li').hover(function(){
					index = $(this).index();
					$(this).children().css('opacity','1');
					var left = index * -300;
					
					$('#box #hot_week #show ul').css('left',left+'px');
				
				},function(){
					$(this).children().css('opacity','0.5');
				});
		})
		
	</script>
  </head>
  
  <body>
 
  		<div id="header">
  			<div id="logo"><img src="indeximg/logo.jpg"></div>
  			<div id="search">
  				<form action="/bookstore/findBookByName.action" method="post">
  					<span>输入书名</span>
  					<input type="text" name="bookName" id="text">
  					<input type="submit" value="搜索" id="submit">
  				</form>			
  			</div>
  			<div id="operator">
  				<a href="/bookstore/getAllBook.action">查看所有</a>
  				<c:if test="${u == null}"><a href="/bookstore/register.action">注册</a></c:if>
  				<c:if test="${u == null}"><a href="/bookstore/login.action">您好,请登录</a></c:if>
  				<c:if test="${u != null}"><a href="/bookstore/invalidate.action">注销</a></c:if>
  				<a href="${pageContext.request.contextPath}/gotoItemList.action">网站管理员</a>
  			</div>	
  		</div>
		<hr/>
  		<div id="lunbo">
  			<img id="lunboImg" src="indeximg/1.jpg">
  		</div>
  		<div id="box">
  			<p>热门品牌 HOT BRANDS</p>
  			<div id="hot_left"><img src="indeximg/hot_left.jpg"/></div>
  			<div id="hot_center">
  				<img src="indeximg/hot_center.jpg"/>
  				<div id="changebox">
  					<div class="change"></div><div class="change"></div><div class="change"></div>
  					<div class="change"></div><div class="change"></div><div class="change"></div>
  					<div class="change"></div><div class="change"></div><div class="change"></div>
  					<div class="change"></div><div class="change"></div><div class="change"></div>
  					<div class="change"></div><div class="change"></div><div class="change"></div>
  					<div class="change"></div><div class="change"></div><div class="change"></div>
  					<div class="change"></div><div class="change"></div><div class="change"></div>
  					<div class="change"></div><div class="change"></div>
  				</div>
  			</div>
  			<div id="hot_week">
  				<div id="show">
					<ul>
						<li><img src="image/1.jpg"></li>
						<li><img src="image/2.jpg"></li>
						<li><img src="image/3.jpg"></li>
						<li><img src="image/4.jpg"></li>
						<li><img src="image/5.jpg"></li>
						<li><img src="image/6.jpg"></li>
					</ul>
				</div>
				<div id="menu">
					<ul>
						<li><img src="image/1.jpg"></li>
						<li><img src="image/2.jpg"></li>
						<li><img src="image/3.jpg"></li>
						<li><img src="image/4.jpg"></li>
						<li><img src="image/5.jpg"></li>
						<li><img src="image/6.jpg"></li>
					</ul>
				</div>
  			</div>
  		</div>
  		<!-- 底部 -->
  		<div id="footer">
  			<div id="top">
  				<ul>
  					<li class="oneLi">了解我们</li>
  					<li>人才招聘</li>
  					<li>关于我们</li>
  					<li>新闻中心</li>
  					<li>公益社区</li>
  					<li>移动客户端</li>
  				</ul>
  				<ul>
  					<li class="oneLi">合作信息</li>
  					<li>全球开店</li>
  					<li>我要开店</li>
  					<li>亚马逊物流</li>
  					<li>加入联盟</li>
  					<li>我要推广</li>
  					<li>合作伙伴</li>
  				</ul>
  				<ul>
  					<li class="oneLi">支付方式</li>
  					<li>亚马逊支付</li>
  					<li>亚马逊帐户</li>
  					<li>货到付款</li>
  					<li>支付宝与财付通</li>
  					<li>网上银行</li>
  				</ul>
  				<ul>
  					<li class="oneLi">帮助和购物指南</li>
  					<li>订单查询</li>
  					<li>配送费收取标准</li>
  					<li>在线自助退换货</li>
  					<li>退换货政策</li>
  					<li>亚马逊助手</li>
  					<li>帮助</li>
  				</ul>
  			</div>
  			<div id="last">
  				<img src="indeximg/indexfooter.jpg"/>
  			</div>
  		</div>
	
  </body>
</html>
