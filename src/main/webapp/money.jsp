<%@ page language="java" pageEncoding="UTF-8"%>
<div class="easyui-panel" data-options="fit:true,border:false">
	<div align="center"
		style="margin: 20px auto auto 20px; font-weight: bold; font-size: 20px;">
			每月收支及结余详情
	</div>
	<div style="margin: 20px 30px auto 30px;">
		<table id="money_datagrid"></table>
		<!-- 工具栏按钮 -->
		<div id="money_toolbar">
			<a id="money_reload" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-reload',plain:true">显示所有</a> <a
				id="money_search" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true">搜索</a>
		</div>

	<!-- 搜索表单 -->
	<div id="money_search_dlg" class="easyui-dialog"
		style="padding: 0px 0px; width: 260px; height: 235px;"
		data-options="closed:true,buttons:'#money_search_dlg-buttons'">
		<form id="money_search_fm">
			<table class="zooqi-frame-text" style="border-spacing: 10px;">
				<tr>
					<td width="70px">日&emsp;期 ：</td>
					<td><input id=datetime1 name="moneyDate" style="width: 116px"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="money_search_dlg-buttons">
		<a id="money_search_button" href="javascript:void(0)"
			class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
			style="width: 90px">搜索</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#money_search_dlg').dialog('close')"
			style="width: 90px">取消</a>
	</div>

	<script type="text/javascript">
		$('#money_datagrid').datagrid({
			url : 'reachMoney',
			fitColumns : true,
			singleSelect : true,
			pagination : true,
			rownumbers : true,
			toolbar : '#money_toolbar',
			remoteSort : false,
			columns : [ [ {
				field : 'expId',
				hidden : true
			},{
				title : '日期',
				field : 'date',
				align : 'center',
				sortable : true,
				width : 255,
			}, {
				title : '总收入',
				field : 'sumIncome',
				align : 'center',
				sortable : true,
				width : 255,
			}, {
				title : '总支出',
				field : 'sumExpent',
				align : 'center',
				sortable : true,
				width : 255,
			}, {
				title : '每月结余',
				field : 'sumMoney',
				align : 'center',
				sortable : true,
				width : 300
			}] ]
		});

		/* 显示所有 */
		$('#money_reload').click(function() {
			$("#money_datagrid").datagrid("load", {});
		});

		/*弹出搜索窗口*/
		$('#money_search').click(
			function() {
				$('#money_search_dlg').dialog('open').dialog('setTitle',
						'搜索每月收支信息');
			});
		/* 搜索 */
		$('#money_search_button').click(function() {
			if (!$('#money_search_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$('#money_datagrid').datagrid('load', {
				
				date : $('#datetime1').val(),
				
			});
			//console.log($('expDate').datebox('getValue'));
			$('#money_search_dlg').dialog('close');
			$('#money_search_fm').form('clear');
		});
   

	</script>
</div>
