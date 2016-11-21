<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">

<title>百顺物流管理系统</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="css/style.css" rel="stylesheet">
<link href="easyui/style.css" rel="stylesheet">
<link href="easyui/themes/icon.css" rel="stylesheet" />
<link href="easyui/themes/default/easyui.css" rel="stylesheet" />
</head>

<body class="easyui-layout">

	<div data-options="region:'north',border:false,collapsible:false"
		style="width: 100%; margin: 0px; padding: 0px; background-color: #448CCA;">
		<img src="img/top.png"
			style="float: left; height: 50px; margin-top: 10px;" />
		<div id="time"
			style="float: right; font-size: 16px; color: #ffffff; margin: 20px;">
		</div>
		<script type="text/javascript">
			change();
			function change() {
				var today;
				today = new Date();
				timeString = today.toLocaleString();
				document.getElementById("time").innerHTML = timeString;
				setTimeout("change();", 1000);
			}
		</script>
	</div>

	<div
		data-options="region:'south',title:'友情链接',border:false,collapsible:false"
		style="height: 60px;"></div>

	<div data-options="region:'west',title:'导航菜单',split:true"
		style="width: 180px;">
		<div class="easyui-accordion" data-options="fit:true">
			<ul class="easyui-tree">
				<c:forEach var="list" items="${requestScope.lists}">
					<c:forEach var="mainMenu" items="${list}">
						<li><span>${mainMenu.getMenuName()}</span> <!-- fun -->
							<ul>
								<c:forEach var="fun" items="${mainMenu.getFun()}">
									<li><a
										onclick="add_tab('${fun.getFunName()}', '${fun.getFunURI()}')">${fun.getFunName()}</a></li>
								</c:forEach>
							</ul> <!-- two -->
							<ul>
								<c:forEach var="subMenu" items="${mainMenu.getChildMenu()}">
									<li><span>${subMenu.getMenuName()}</span>

										<ul>
											<c:forEach var="fun" items="${subMenu.getFun()}">
												<li><a
													onclick="add_tab('${fun.getFunName()}', '${fun.getFunURI()}')">${fun.getFunName()}</a></li>
											</c:forEach>
										</ul></li>
								</c:forEach>
							</ul></li>
					</c:forEach>
				</c:forEach>
			</ul>
		</div>
	</div>

	<!-- 显示tab -->
	<div data-options="region:'center'" style="background: #eee;">
		<div id="tabs" class="easyui-tabs" data-options="fit:true"></div>
	</div>

	<script src="easyui/jquery.min.js"></script>
	<script src="easyui/jquery.easyui.min.js"></script>
	<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script src="easyui/script.js"></script>

	<script type="text/javascript">
		$('document').ready(function() {
			/* 初始化欢迎页 */
			add_tab("欢迎使用", "");
		});

		/* 添加tab */
		function add_tab(title, url) {
			if (!$('#tabs').tabs('exists', title)) {
				$('#tabs').tabs('add', {
					title : title,
					href : url,
					closable : true
				});
			} else {
				$('#tabs').tabs('select', title);
				var tab = $('#tabs').tabs('getSelected');
				tab.panel('refresh', url);
			}
		}
	</script>
</body>

</html>
