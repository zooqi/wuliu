<%@ page language="java" pageEncoding="UTF-8"%>
<div class="easyui-panel" data-options="fit:true,border:false">
	<div align="center"
		style="margin: 20px auto auto 20px; font-weight: bold; font-size: 20px;">

	</div>
	<div style="margin: 20px 30px auto 30px;">
		<table id="expent_datagrid"></table>
		<!-- 工具栏按钮 -->
		<div id="expent_toolbar">
			<a id="expent_reload" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-reload',plain:true">显示所有</a> <a
				id="expent_search" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true">搜索</a>
		</div>

	<!-- 搜索表单 -->
	<div id="expent_search_dlg" class="easyui-dialog"
		style="padding: 0px 0px; width: 260px; height: 235px;"
		data-options="closed:true,buttons:'#expent_search_dlg-buttons'">
		<form id="expent_search_fm">
			<table class="zooqi-frame-text" style="border-spacing: 10px;">
				<tr>
					<td width="70px">职 &nbsp;工 &nbsp;号：</td>
					<td><input id="expent_expEmpNum" name="expEmpNum"
						style="width: 114px"></td>
				</tr>
				<tr>
					<td width="70px">员工姓名：</td>
					<td><input id="expent_expEmpName" name="expEmpName"
						style="width: 114px"></td>
				</tr>
				<tr>
					<td width="70px">用&emsp;&emsp;途 ：</td>
					<td><input id="expent_expFunction" name="expFunction"
						style="width: 114px"></td>
				</tr>
				<tr>
					<td width="70px">日&emsp;&emsp;期 ：</td>
					<td><input class="easyui-datebox" name="expDate"
						id="expent_expDate" style="width: 116px"></td>

				</tr>
			</table>
		</form>
	</div>
	<div id="expent_search_dlg-buttons">
		<a id="expent_search_button" href="javascript:void(0)"
			class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
			style="width: 90px">搜索</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#expent_search_dlg').dialog('close')"
			style="width: 90px">取消</a>
	</div>

	<script type="text/javascript">
		$('#expent_datagrid').datagrid({
			url : 'expReach',
			fitColumns : true,
			singleSelect : true,
			pagination : true,
			rownumbers : true,
			toolbar : '#expent_toolbar',
			remoteSort : false,
			columns : [ [ {
				field : 'expId',
				hidden : true
			}, {
				title : '职工号',
				field : 'expEmpNum',
				align : 'center',
				sortable : true,
				width : 150,
				formatter : function(value, row, index) {
					if (row.expId) {
						return row.expEmpNum;
					} else {
						return value;
					}
				}
			}, {
				title : '姓名',
				field : 'expEmpName',
				align : 'center',
				sortable : true,
				width : 100,
				formatter : function(value, row, index) {
					if (row.expId) {
						return row.expEmpName;
					} else {
						return value;
					}
				}
			}, {
				title : '用途',
				field : 'expFunction',
				align : 'center',
				sortable : true,
				width : 100,
				formatter : function(value, row, index) {
					if (row.expId) {
						return row.expFunction;
					} else {
						return value;
					}
				}
			}, {
				title : '金额',
				field : 'expMoney',
				align : 'center',
				sortable : true,
				width : 140,
			}, {
				title : '时间',
				field : 'expDate',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '备注',
				field : 'expRemark',
				align : 'center',
				sortable : true,
				width : 100
			} ] ]
		});

		/* 显示所有 */
		$('#expent_reload').click(function() {
			$("#expent_datagrid").datagrid("load", {});
		});

		/*弹出搜索窗口*/
		$('#expent_search').click(
				function() {
					$('#expent_search_dlg').dialog('open').dialog('setTitle',
							'搜索支出信息');
				});
		/* 搜索 */
		$('#expent_search_button').click(function() {
			if (!$('#expent_search_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$('#expent_datagrid').datagrid('load', {
				expEmpNum : $('#expent_expEmpNum').val(),
				expEmpName : $('#expent_expEmpName').val(),
				expDate : $('#expent_expDate').datebox('getValue'),
				expFunction : $('#expent_expFunction').val()
			});
			//console.log($('expDate').datebox('getValue'));
			$('#expent_search_dlg').dialog('close');
			$('#expent_search_fm').form('clear');
		});

	</script>

</div>
