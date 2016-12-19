<%@ page language="java" pageEncoding="UTF-8"%>
<div class="easyui-panel" data-options="fit:true,border:false">
	<div align="center"
		style="margin: 20px auto auto 20px; font-weight: bold; font-size: 20px;">

	</div>
	<div style="margin: 20px 30px auto 30px;">
		<table id="income_datagrid"></table>
		<!-- 工具栏按钮 -->
		<div id="income_toolbar">
			<a id="income_reload" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-reload',plain:true">显示所有</a> <a
				id="income_search" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true">搜索</a>
		</div>
	<!-- 搜索表单 -->
	<div id="income_search_dlg" class="easyui-dialog"
		style="padding: 0px 0px; width: 260px; height: 160px;"
		data-options="closed:true,buttons:'#income_search_dlg-buttons'">
		<form id="income_search_fm">
			<table class="zooqi-frame-text" style="border-spacing: 10px;">
				<tr>
					<td width="70px">日&emsp;期 ：</td>
					<td><input class="easyui-datebox" name="logSendDate"
						id="income_logSendDate" style="width: 116px"></td>
				</tr>
				<tr>
					<td width="70px">车牌号：</td>
					<td><input name="logCarLicence"
						id="income_logCarLicence" style="width: 113px"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="income_search_dlg-buttons">
		<a id="income_search_button" href="javascript:void(0)"
			class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
			style="width: 90px">搜索</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#income_search_dlg').dialog('close')"
			style="width: 90px">取消</a>
	</div>

	<script type="text/javascript">
		$('#income_datagrid').datagrid({
			url : 'reachIncome',
			fitColumns : true,
			singleSelect : true,
			pagination : true,
			rownumbers : true,
			toolbar : '#income_toolbar',
			remoteSort : false,
			columns : [ [ {
				field : 'logId',
				hidden : true
			}, {
				title : '时间',
				field : 'logSendDate',
				align : 'center',
				sortable : true,
				width : 100,
			}, {
				title : '车牌号',
				field : 'logCarLicence',
				align : 'center',
				sortable : true,
				width : 100,
			}, {
				title : '总收入',
				field : 'sumGoPay',
				align : 'center',
				sortable : true,
				width : 100,
			}, {
				title : '总货款扣',
				field : 'sumGoDamagePay',
				align : 'center',
				sortable : true,
				width : 100,
			}, {
				title : '总回扣',
				field : 'sumGoCommission',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '总中转费',
				field : 'sumGoTransitPay',
				align : 'center',
				sortable : true,
				width : 100
			} ] ]
		});

		/* 显示所有 */
		$('#income_reload').click(function() {
			$("#income_datagrid").datagrid("load", {});
		});
		
		/*弹出搜索窗口*/
		$('#income_search').click(
			function() {
				$('#income_search_dlg').dialog('open').dialog('setTitle',
						'搜索收入信息');
			});
		/* 搜索 */
		$('#income_search_button').click(function() {
			if (!$('#income_search_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$('#income_datagrid').datagrid('load', {
				logCarLicence : $('#income_logCarLicence').val(),
				logSendDate : $('#income_logSendDate').datebox('getValue'),
			});
			$('#income_search_dlg').dialog('close');
			$('#income_search_fm').form('clear');
		});
	</script>

</div>
