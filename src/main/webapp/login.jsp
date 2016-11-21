<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String logNum = null;
	String logPasswd = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("logNum")) {
				logNum = cookie.getValue();
			}
			if (cookie.getName().equals("logPasswd")) {
				logPasswd = cookie.getValue();
			}
		}
	}
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">

<title>标题</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="css/login.css" rel="stylesheet">
</head>

<body>
	<form id="cookie_login_form" action="login" method="post">
		<div id="main">
			<div id="head"></div>
			<div id="two">
				<div id="background">
					<img src="img/map.png" width="700" height="300" />
				</div>
				<div id="login">
					<div id="four">
						<span id="point">
						 <c:choose>
								<c:when test="${empty requestScope.error1}">
									<c:choose>
										<c:when test="${empty requestScope.error2}">
											<c:out value="公共场所不建议自动登录，以防账号丢失" />
										</c:when>
										<c:otherwise>
											${error2}
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									${error1}
								</c:otherwise>
							</c:choose>
						</span>
					</div>
					
					<h2 style="text-align: center">百顺物流公司登陆系统</h2>
					<br> <br> 
					<label for="loginname"class="login-label name-label" id="ll"></label> 
					<input id="loginname" type="text" class="itxt" name="logNum" value="<%=logNum != null ? logNum : ""%>" placeholder="邮箱/用户名/已验证手机" onclick="test1();" /> 
					<br> <br>
					<label for="password" class="password-label name-label" id="ps"></label>
					<input id="password" type="password" class="itxt" name="logPasswd" value="<%=logPasswd != null ? logPasswd : ""%>" placeholder="密码" onclick="test2();" /> 
					<br> 
					<br>
					
					&ensp;&ensp;&ensp;
					<input type="checkbox" name="auto" value="yes"/><span style='font-size: 13.2px;color:gray'>一天内自动登录</span>
					<br> 
					<input id="loginButton" type="submit" name="login" value="登&nbsp;&nbsp;&nbsp;陆" style='font-size: 20px; width: 293px; height: 35px; background-color: #E24D46' />
					<br> 
					<br> 
					 &ensp;&ensp;&ensp;&ensp;
					<a href="http://www.divcss5.com/html/h635.shtml"style='font-size: 14px;text-align: center'>网上下单</a>
					
					&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
					<a href="http://www.divcss5.com/html/h635.shtml" style="font-size: 14px;text-align: left;">帮&nbsp;助?</a>
				</div>
			</div>
			<div id="three" >
				<a href="">关于我们</a> &nbsp;|&nbsp; <a href="">联系我们</a> &nbsp;|&nbsp;
				<a href="">人才招聘</a> &nbsp;|&nbsp; <a href="">商家入驻</a> &nbsp;|&nbsp;
				<a href="">广告服务</a> &nbsp;|&nbsp; <a href="">友情链接</a> &nbsp;|&nbsp;
				<a href="">销售联盟</a> &nbsp;|&nbsp; <a href="">百顺公益</a>
			</div>
		</div>
	</form>
	
	<!--  
	<form id="cookie_login_form" action="login" method="post">
		<input id="cookie_logNum" name="logNum" type="hidden" value="<%=logNum != null ? logNum : ""%>">
		<input id="cookie_logPasswd" name="logPasswd" type="hidden" value="<%=logPasswd != null ? logPasswd : ""%>">
	</form>
	-->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var logNum = $('#loginname').val();
			var logPasswd = $('#password').val();
			console.log(logNum);
			console.log(logPasswd)
			if(logNum!='') {
				if(logPasswd!='') {
					$('#cookie_login_form').submit();
				}
			}
		});

		function test1()
		{
			var loginLabel=document.getElementById("ll");
			loginLabel.style.backgroundPosition="0px -48px";
		}
		function test2(){
			var pass=document.getElementById("ps");
			pass.style.backgroungPosition="-49px -48px";
		}
	</script>
</body>
</html>
