<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.json.JSONObject"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String row = (String) session.getAttribute("row");
	JSONObject json = new JSONObject(row);
	session.removeAttribute("row");
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style media=print type="text/css">
.noprint {
	visibility: hidden;
}
</style>

<style media=print type="text/css">
.print {
	visibility: visible;
}
</style>

<body style="font-size: 15px;text-align: center; font-family: '宋体'">
 桂林百顺物流有限公司&nbsp;&nbsp;&nbsp;
 </br>
  <table width="205" align="center" cellspacing="0"
			style="font-size: 15px; ">
			<tr>
				<td>货号</td>
				<td id="goBank" ">
				<input type="text" style="width: 140px; font-size: 15px;border: 0px;"
					value="<%=json.has("goBank") ? json.get("goBank") : ""%>" />
				</td>
			</tr>
			<tr>
				<td>货物名</td>
				<td id="goName">
				<input type="text" style="width: 140px; font-size: 15px; border: 0px;"
					value="<%=json.has("goName") ? json.get("goName") : ""%>" />
				</td>
			</tr>
			<tr>
				<td>目的地</td>
				<td id="goName">
				<input type="text" style="width: 140px; font-size: 15px; border: 0px;"
					value="<%=json.has("goSiteEnd") ? json.get("goSiteEnd") : ""%>" />
				</td>
			</tr>
			<tr>
				<td >收货人</td>
				<td id="goForMan" ><input type="text" style="width: 140px; font-size: 15px; border: 0px;"
					value="<%=json.has("goForMan") ? json.get("goForMan") : ""%>" />
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td id="goForPhone" ><input type="text" style="width: 140px; font-size: 15px; border: 0px;"
					value="<%=json.has("goForPhone") ? json.get("goForPhone") : ""%>" />
				</td>
			</tr>
			<tr>
				<td>日期</td>
				<td id="logSendDate" ><input type="text" style="width: 140px; font-size: 15px; border: 0px;"
					value="<%=json.has("logSendDate") ? json.get("logSendDate") : ""%>"/>
				</td>
			</tr>
		</table>
				<br> <input type="button" class="noprint"
			value="打&nbsp;&nbsp;印" onclick="pagesetup_null()"
			style='font-size: 13px; width: 50px; height: 20px; background-color: #F0F0F0' />
		&nbsp;&nbsp; <input class="noprint" type="button"
			value="返&nbsp;&nbsp;回" onclick="returnBefore()"
			style='font-size: 13px; width: 50px; height: 20px; background-color: #F0F0F0' />
		&nbsp;&nbsp;
		<br>
		<script type="text/javascript">
			function returnBefore() {
				window.history.go(-1);
			}
		</script>
		<script type="text/javascript">
			function pagesetup_null() {
				window.print();
			}
		</script>
</body>
</html>