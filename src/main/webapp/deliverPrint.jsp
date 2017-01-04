<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.json.JSONObject"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String row = (String) session.getAttribute("row");
	JSONObject json = new JSONObject(row);
	session.removeAttribute("row");
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
<style>
@media print {
	table {
		border: 0pt
	}
}
</style>
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
</head>

<body style="text-align: center; font-family: '宋体'">
	<div>
		<b  style="font-size: 25px; font-family: '黑体'">桂林市百顺物流有限责任公司运输合同</b>
		<br> <b  style="font-size: 15pxfont-family: '黑体'">桂林<—>山东、东北专线</b>
		<br>
		<table width="800" align="center" cellspacing="0"
			style="font-size: 18px; text-align: center">
			<tr>
				<td class="noprint" width="95" style="text-align: center;">货运日期</td>
				<td id="logSendDate" width="140"><input class="noprint"
					type="text" style="width: 140px; font-size: 18px; border: 0px;"
					class="print"
					value="<%=json.has("logSendDate") ? json.get("logSendDate") : ""%>" />
				</td>
				<td class="noprint" width="60" style="text-align: center;">起始地</td>
				<td id="goSiteStart" width="120"><input class="noprint"
					type="text" style="width: 100px; font-size: 18px; border: 0px;"
					class="print"
					value="<%=json.has("logSiteStart") ? json.get("logSiteStart") : ""%>" />
				</td>
				<td class="noprint" width="60" style="text-align: center;">到达地</td>
				<td id="goSiteEnd" width="120"><input class="noprint"
					type="text" style="width: 100px; font-size: 18px; border: 0px;"
					class="print"
					value="<%=json.has("goSiteEnd") ? json.get("goSiteEnd") : ""%>" />
				</td>
				<td class="noprint" width="40" style="text-align: center;">货号</td>
				<td id="goBank" width="120"><input class="noprint"
					type="text" style="width: 100px; font-size: 18px; border: 0px;"
					class="print"
					value="<%=json.has("goBank") ? json.get("goBank") : ""%>" />
				</td>
			</tr>
		</table>
		<table width="800" border="1" cellspacing="0" align="center"
			style="font-family: '宋体'; font-size: 18px; text-align: center">
			<tr>
				<td  width="100">收货单位</td>
				<td width="100"  id="goSendMan"><input
					type="text"
					style="width: 100px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goSendMan") ? json.get("goSendMan") : ""%>" /></td>
				<td  width="100">电话</td>
				<td  width="120" id="goSendPhone"><input
					type="text"
					style="width: 120px; font-size: 18px; border: 0px; text-align: center;"
					class="print"
					value="<%=json.has("goSendPhone") ? json.get("goSendPhone") : ""%>" />
				</td>
				<td  width="100">地址</td>
				<td  colspan="5" width="200" id="goSendAddress">
					<input type="text"
					style="width: 200px; font-size: 18px; border: 0px; text-align: center;"
					class="print"
					value="<%=json.has("goSendAddress") ? json.get("goSendAddress") : ""%>" />
				</td>
			</tr>
			<tr>
				<td  width="100">发货单位</td>
				<td  width="100" id="goForMan"><input
					type="text"
					style="width: 100px; font-size: 18px; border: 0px; text-align: center;"
					class="print"
					value="<%=json.has("goForMan") ? json.get("goForMan") : ""%>" /></td>
				<td  width="100">电话</td>
				<td  width="120" id="goForPhone"><input
					type="text"
					style="width: 120px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goForPhone") ? json.get("goForPhone") : ""%>" /></td>
				<td  width="100">地址</td>
				<td  colspan="5" width="200" id="goForAddress">
					<input type="text"
					style="width: 200px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goForAddress") ? json.get("goForAddress") : ""%>" />
				</td>
			</tr>
			<tr >
				<td width="100">货物名称</td>
				<td width="50">包装</td>
				<td width="50">数量</td>
				<td width="50">重量</td>
				<td width="50">体积</td>
				<td width="70">保险费</td>
				<td width="90">货物运费</td>
				<td width="90">付款方式</td>
				<td width="90">提货方式</td>
			</tr>
			<tr>
				<td  id="goName"><input type="text"
					style="width: 100px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goName") ? json.get("goName") : ""%>" /></td>
				<td  id="goNum"><input type="text"
					style="width: 50px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goPack") ? json.get("goPack") : ""%>" /></td>
				<td  id="goPack"><input type="text"
					style="width: 50px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goNum") ? json.get("goNum") : ""%>" /></td>
				<td id="goWeight"><input type="text"
					style="width: 100px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goWeight") ? json.get("goWeight") : ""%>" /></td>
				<td  id="goVolume"><input type="text"
					style="width: 50px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goVolume") ? json.get("goVolume") : ""%>" /></td>
				<td  id="goInsurancePay"><input type="text"
					style="width: 70px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goInsurancePay") ? json.get("goInsurancePay") : ""%>" />
				</td>
				<td  id="goPay"><input type="text"
					style="width: 90px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goPay") ? json.get("goPay") : ""%>" /></td>
				<td  id="goPayWay"><input type="text"
					style="width: 90px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goPayWay") ? json.get("goPayWay") : ""%>" /></td>
				<td id="goGetWay"><input type="text"
					style="width: 90px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goGetWay") ? json.get("goGetWay") : ""%>" /></td>
			</tr>
			<tr>
				<td width="100">代收货款</td>
				<td  width="100" colspan="3" id="goReplacePay">
					<input type="text"
					style="width: 100px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goReplacePay") ? json.get("goReplacePay") : ""%>" />
				</td>
				<td  width="100">合计</td>
				<td  colspan="5" width="100"><input type="text"
					style="width: 100 px; font-size: 18px; border: 0px; text-align: center"
					class="print" value="" /></td>
			</tr>
			<tr>
				<td>备注</td>
				<td  colspan="8" id="goRemark"><input
					type="text"
					style="width: 200px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goRemark") ? json.get("goRemark") : ""%>" /></td>
			</tr>
		</table>
		<table width="800" cellspacing="0"align="center" style="font-family:'宋体'; font-size:18px;">
			<tr>
				<td width="90">公司地址：</td>
				<td id="" width="300">桂林市叠彩区76号小麻雀物流基地</td> 
				<td>提</td>
				<td width="300">东二环德鑫市场院内百顺物流一号仓</td>
			</tr>
			<tr>
				<td>电话:</td>
				<td>0773-22034</td>
				<td>货</td>
				<td>电话：0773-3888811</td>
			</tr>
			<tr>
				<td>传真:</td>
				<td>0773-8990736</td>
				<td>地</td>
				<td>手机：13169663456</td>
			</tr>
		</table>
		<table width="800" cellspacing="0" align="center" style="font-family:'宋体'; font-size:18px;">
			<tr>
				<td>收货人签章：</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>身份证号码：</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>托运人签章：</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</table>
		<br> <br> <input type="button" class="noprint"
			value="打&nbsp;&nbsp;印" onclick="pagesetup_null()"
			style='font-size: 18px; width: 100px; height: 30px; background-color: #F0F0F0' />
		&nbsp;&nbsp;&nbsp;&nbsp; <input class="noprint" type="button"
			value="返&nbsp;&nbsp;回" onclick="returnBefore()"
			style='font-size: 18px; width: 100px; height: 30px; background-color: #F0F0F0' />
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
	</div>
</body>
</html>
