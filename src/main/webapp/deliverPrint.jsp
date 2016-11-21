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
	visibility: hidden
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
		<b class="noprint" style="font-size: 25px; font-family: '黑体'">桂林市百顺物流有限责任公司运输合同</b>
		<br> <b class="noprint" style="font-size: 15pxfont-family: '黑体'">桂林<—>山东、东北专线</b>
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
				<td class="noprint" width="90" style="text-align: center;">起始地</td>
				<td id="goSiteStart" width="150"><input class="noprint"
					type="text" style="width: 150px; font-size: 18px; border: 0px;"
					class="print"
					value="<%=json.has("goSiteStart") ? json.get("goSiteStart") : ""%>" />
				</td>
				<td class="noprint" width="60" style="text-align: center;">到达地</td>
				<td colspan="5" id="goSiteEnd" width="150"><input type="text"
					style="width: 200px; font-size: 18px; border: 0px; text-align: left;"
					class="print"
					value="<%=json.has("goSiteEnd") ? json.get("goSiteEnd") : ""%>" /></td>
			</tr>
		</table>

		<table width="800" border="1" cellspacing="0" align="center"
			style="font-family: '宋体'; font-size: 18px; text-align: center">
			<tr>
				<td class="noprint" width="100">收货单位</td>
				<td width="100" class="noprint" id="goSendMan"><input
					type="text"
					style="width: 100px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goSendMan") ? json.get("goSendMan") : ""%>" /></td>
				<td class="noprint" width="100">电话</td>
				<td class="noprint" width="120" id="goSendPhone"><input
					type="text"
					style="width: 120px; font-size: 18px; border: 0px; text-align: center;"
					class="print"
					value="<%=json.has("goSendPhone") ? json.get("goSendPhone") : ""%>" />
				</td>
				<td class="noprint" width="100">地址</td>
				<td class="noprint" colspan="5" width="200" id="goSendAddress">
					<input type="text"
					style="width: 200px; font-size: 18px; border: 0px; text-align: center;"
					class="print"
					value="<%=json.has("goSendAddress") ? json.get("goSendAddress") : ""%>" />
				</td>
			</tr>
			<tr>
				<td class="noprint" width="100">发货单位</td>
				<td class="noprint" width="100" id="goForMan"><input
					type="text"
					style="width: 100px; font-size: 18px; border: 0px; text-align: center;"
					class="print"
					value="<%=json.has("goForMan") ? json.get("goForMan") : ""%>" /></td>
				<td class="noprint" width="100">电话</td>
				<td class="noprint" width="120" id="goForPhone"><input
					type="text"
					style="width: 120px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goForPhone") ? json.get("goForPhone") : ""%>" /></td>
				<td class="noprint" width="100">地址</td>
				<td class="noprint" colspan="5" width="200" id="goForAddress">
					<input type="text"
					style="width: 200px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goForAddress") ? json.get("goForAddress") : ""%>" />
				</td>
			</tr>
			<tr class="noprint">
				<td width="100">货物名称</td>
				<td width="50">数量</td>
				<td width="50">包装</td>
				<td width="50">重量</td>
				<td width="50">体积</td>
				<td width="70">保险费</td>
				<td width="90">货物运费</td>
				<td width="90">付款方式</td>
				<td width="90">提货方式</td>
			</tr>
			<tr>
				<td class="noprint" id="goName"><input type="text"
					style="width: 100px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goName") ? json.get("goName") : ""%>" /></td>
				<td class="noprint" id="goNum"><input type="text"
					style="width: 50px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goNum") ? json.get("goNum") : ""%>" /></td>
				<td class="noprint" id="goPack"><input type="text"
					style="width: 50px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goPack") ? json.get("goPack") : ""%>" /></td>
				<td class="noprint" id="goWeight"><input type="text"
					style="width: 50px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goWeight") ? json.get("goWeight") : ""%>" /></td>
				<td class="noprint" id="goVolume"><input type="text"
					style="width: 50px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goVolume") ? json.get("goVolume") : ""%>" /></td>
				<td class="noprint" id="goInsurancePay"><input type="text"
					style="width: 70px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goInsurancePay") ? json.get("goInsurancePay") : ""%>" />
				</td>
				<td class="noprint" id="goPay"><input type="text"
					style="width: 90px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goPay") ? json.get("goPay") : ""%>" /></td>
				<td class="noprint" id="goPayWay"><input type="text"
					style="width: 90px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goPayWay") ? json.get("goPayWay") : ""%>" /></td>
				<td class="noprint" id="goGetWay"><input type="text"
					style="width: 90px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goGetWay") ? json.get("goGetWay") : ""%>" /></td>
			</tr>
			<tr>
				<td class="noprint" width="100">代收货款</td>
				<td class="noprint" width="100" colspan="3" id="goReplacePay">
					<input type="text"
					style="width: 100px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goReplacePay") ? json.get("goReplacePay") : ""%>" />
				</td>
				<td class="noprint" width="100">合计</td>
				<td class="noprint" colspan="5" width="100"><input type="text"
					style="width: 20px; font-size: 18px; border: 0px; text-align: center"
					class="print" value="" /></td>
			</tr>
			<tr>
				<td class="noprint">备注</td>
				<td class="noprint" colspan="8" id="goRemark"><input
					type="text"
					style="width: 200px; font-size: 18px; border: 0px; text-align: center"
					class="print"
					value="<%=json.has("goRemark") ? json.get("goRemark") : ""%>" /></td>
			</tr>
			<tr>
				<td class="noprint" colspan="9" align="left"
					style="font-family: '宋体'; font-size: 17px;">
					1、托运部门并不拆开验收，运到时包装完好，如内容短损，承运部门不责任。2、托运物品不得夹带易燃易爆等违法物品,不得虚假托运，否则，因此发生一切损失和后果，由托运人负责。3、托运人托运的货物应上全额保险，已参加保险的货物发生丢件和损坏的，按保险条理规定理赔；如不参加保险，发生货物丢失或损坏，本部按照运费的1~5倍赔偿。4、文物、贵重物品及陶瓷、玻璃、无包装等易碎品，本部只负丢失责任，不负损坏责任。5、下列情况承运方不负赔偿责任：运输途中的保管期内变质、失效、自然合理的损耗；交通事故，车辆的严重故障，堵路或客观因素引起的延迟交货;包装完好时的内部的变化；交接之后出现的任何情况，造成货运货物损坏、丢失等任何损失，承运人不承担损害赔偿责任。
				</td>
			</tr>
		</table>
		<br> <br> <input class="noprint" type="button"
			value="打&nbsp;&nbsp;印" onclick="pagesetup_null()"
			style='font-size: 18px; width: 100px; height: 30px; background-color: #F0F0F0' />
		&nbsp;&nbsp;&nbsp;&nbsp; <input class="noprint" type="button"
			value="返&nbsp;&nbsp;回" onclick="returnBefore()"
			style='font-size: 18px; width: 100px; height: 30px; background-color: #F0F0F0' />
		<br>
		<!--  
<table width="800" class="noprint" cellspacing="0"align="center" style="font-family:'宋体'; font-size:18px;">
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
		<td>手机:</td>
		<td>13457663456</td>
		<td>地</td>
		<td>手机：13169663456</td>
	</tr>
	<tr>
		<td>传真:</td>
		<td>0773-8990736</td>
	</tr>
</table>
-->
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
