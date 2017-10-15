<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String warning = (String)request.getAttribute("warning");//当注册失败时，后台modelAndView.addObject("warning","对不起，该用户名已存在");
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录界面</title>
    
	<meta charset="utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		li{
			list-style: none;
		}
		#header{
			width: 100%;
			height: 70px;
		}
		#header img{
			display: block;
			margin-left: 300px;
			padding-top: 15px;
		}
		#center{
			position: relative;
			background: #3268A5;
		}
		#center #img{
			display: block;
			margin: 0 auto;
		}
		#center #box{
			position: absolute;
			width: 350px;
			height: 404px;
			background: #fff;
			top:100px;
			right:150px;
		}
		#center #box #p1{
			position: absolute;
			left: 27px;
			top:41px;
			font-size: 16px;
			color: #3c3c3c;
			font-weight: 700;
		}
		#center #box #p2{
			position: absolute;
			left: 27px;
			top:62px;
			font-size: 16px;
			color: red;
			font-weight: 700;
		}
		#center #box #user{
			position: absolute;
			left: 27px;
			top: 104px;
		}
		#center #box #user input{
			width: 240px;
			font-size: 14px;
			line-height: 18px;
			border: 1px solid #ddd;
			height: 36px;
			border-left: none;
			text-indent: 5px;
		}
		#center #box #user img{
			display: block;
			float: left;
		}
		#center #box #pass{
			position: absolute;
			left: 27px;
			top: 171px;
		}
		#center #box #pass input{
			width: 240px;
			font-size: 14px;
			line-height: 18px;
			border: 1px solid #ddd;
			height: 36px;	
			border-left: none;
			text-indent: 5px;	
		}
		#center #box #pass img{
			display: block;
			float: left;			
		}
		/************************************/
		#center #box #randomNum{
			position: absolute;
			left: 27px;
			top: 238px;
		}
		#center #box #randomNum input{
			width: 160px;
			font-size: 14px;
			line-height: 18px;
			border: 1px solid #ddd;
			height: 36px;	
			border-left: none;
			text-indent: 5px;	
		}
		#center #box #randomNum img{
			display: block;
			float: left;			
		}
		#center #box #form #register{
			position: absolute;
			left: 27px;
			top:300px;
			width: 285px;
			height: 41px;
			border: none;
			background: #AF0000;
			font-size: 16px;
			font-weight: 700;
			color: #FFFFFF;
			border-radius: 5px;
		}
		
		#footer{
			width: 100%;
			height: 300px;
		}
		#footer #box{
			margin: 0 auto;
			width: 1190px;
		}
		#footer #box ul{
			width: 100%;
			display: block;
		}
		#footer #box ul li{
			float: left;
			color: #000;
			margin-left: 6px;
			line-height: 25px;
			font-size: 12px;
		}
		#footer #box #second li{
			margin-right: 11px;
		}
		#footer #box p{
			font-size: 12px;
			display: block;
			margin-left: 50px;
			line-height: 20px;
			color: #666;
		}
		#footer #box #three li{
			color: #666;
		}
	</style>
	
  </head>
  
  <body>
  		<div id="header">
  			<img src="indeximg/tianmao.jpg">
  		</div>
  		<div id="center">
  			<img id="img" src="indeximg/registerbk.jpg">
  			<div id="box">
  				<p id="p1">免费注册</p>
  				<p id="p2"><c:if test="${warning != null}"><%=warning%></c:if></p>
  				<form action="/bookstore/insertUser.action" method="post" id="form">
    				<div id="user"><img src="indeximg/user.jpg"><input type="text" name="username" placeholder="输入用户名"></div>
  					<div id="pass"><img src="indeximg/pass.jpg"><input type="text" name="password" placeholder="输入密码"></div>
  					<div id="randomNum"><img src="/bookstore/getImg.action"><input type="text" name="randomNum" placeholder="输入验证码"></div>
  					<input type="submit" value="注册" id="register">
    			</form> 				
  			</div>
  		</div>
    	<div id="footer">
    		<div id="box">
    			<ul id="first">    
    				<li>关于天猫</li>
    				<li>帮助中心</li>
    				<li>开放平台</li>
    				<li>诚聘英才</li>
    				<li>联系我们</li>
    				<li>网站合作</li>
    				<li>法律声明</li>
    				<li>知识产权</li>
    				<li>廉正举报</li>
    			</ul>
    			<br/>
    			<ul id="second">
    				<li>阿里巴巴集团</li>
    				<li>淘宝网</li>
    				<li>天猫</li>
    				<li>聚划算</li>
    				<li>全球速卖通</li>
    				<li>阿里巴巴国际交易市场</li>
    				<li>1688</li>
    				<li>阿里妈妈</li>
    				<li>飞猪</li>
    				<li>阿里云计算</li>
    				<li>YunOS</li>
    				<li>阿里通信</li>
    				<li>万网</li>
    				<li>高德</li>
    				<li>UC</li>
    				<li>友盟</li>
    				<li>虾米</li>
    				<li>阿里星球</li>
    				<li>来往</li>
    				<li>钉钉</li>
    				<li>支付宝</li>
    			</ul>
    			<br/>
				<ul id="three">
					<li>增值电信业务经营许可证： 浙B2-20110446</li>
					<li>网络文化经营许可证：浙网文[2015]0295-065号</li>
					<li>互联网药品交易服务资格证书 国A20150001 </li>
				</ul>
				<br/><br/>
				<p id="p1">互联网药品信息服务资质证书编号：浙-（经营性）-2012-0005</p>
				<p id="p2">© 2003-2016 TMALL.COM 版权所有</p>
    		</div>
    	</div>
  </body>
</html>


<!-- 
请注册<br/><br/>
    <form action="/bookstore/insertUser.action" method="post">
    	用户名：<input type="text" name="username"><br/><br/>
    	密码：<input type="text" name="password"><br/><br/>
    	<input type="submit" value="注册">

 -->