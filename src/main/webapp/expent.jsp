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
				id="expent_add" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:true">添加</a> <a
				id="expent_edit" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit',plain:true">编辑</a> <a
				id="expent_delete" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-remove',plain:true">删除</a> <a
				id="expent_search" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true">搜索</a>
		</div>
		<!-- 对话框 -->
		<div id="expent_edit_dlg" class="easyui-dialog"
			style="padding: 0px 0px; width: 500px; height: 230px;"
			data-options="closed:true,buttons:'#expent_edit_dlg-buttons'">
			<form id="expent_edit_fm">
				<div id="expent_edit_tabs" class="easyui-tabs">
					<div title="支出基本信息">
						<table class="zooqi-frame-text" border="1"
							style="border-collapse: collapse; border: 2px solid #D6E3F4; margin-left: 3px; margin-right: 1px"
							cellspacing="35%" cellpadding="8">
							<tr>
								<td style="width: 93px; text-align: center;">职&nbsp;工&nbsp;号：</td>
							    <td><input id="expent" name="expEmpNum" style="width: 120px"></td>
								<td style="width: 93px; text-align: center;">姓&emsp;&emsp;名：</td>
								<td><input id="expent" name="expEmpName" style="width: 113px"></td>
							</tr>
							
							<tr>
								<td style="width: 93px; text-align: center;">用&emsp;&emsp;途：</td>
								<td><input id="expent" name="expFunction"
									style="width: 120px"></td>
								<td style="width: 93px; text-align: center;">金&emsp;&emsp;额：</td>
								<td><input id="expent" name="expMoney"
									style="width: 113px"></td>
							</tr>
							<tr>
								
								<td style="width: 93px; text-align: center;">时&emsp;&emsp;间：</td>
								<td><input class="easyui-datebox" name="expDate"
									data-options="validType:'length[0,32]'" style="width: 120px">
								</td>
								<td style="width: 93px; text-align: center;">备&emsp;&emsp;注：</td>
								<td><input id="expent" name="expRemark"
									style="width:113px"></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>

		<!-- 按钮 -->
		<div id="expent_edit_dlg-buttons">
			<a id="expent_edit_submit_button" href="javascript:void(0)"
				class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
				style="width: 90px">保存</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
				onclick="javascript:$('#expent_edit_dlg').dialog('close');$('#expent_edit_fm').form('clear');"
				style="width: 90px">取消</a>
		</div>
	</div>

	<!-- 搜索表单 -->
	<div id="expent_search_dlg" class="easyui-dialog"
		style="padding: 0px 0px; width: 250px; height: 230px;"
		data-options="closed:true,buttons:'#expent_search_dlg-buttons'">
		<form id="expent_search_fm">
			<table class="zooqi-frame-text" style="border-spacing: 10px;">
				<tr>
					<td width="70px">职 &nbsp;工 &nbsp;号 ：</td>
					<td><input id="expent_expEmpNum" name="expEmpNum"
						style="width: 114px"></td>
				</tr>
				<tr>
					<td width="70px">员工姓名：</td>
					<td><input id="expent_expEempName" name="expEmpName"
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
			},{
				title : '备注',
				field : 'expRemark',
				align : 'center',
				sortable : true,
				width : 100
			}] ]
		});

		/* 显示所有 */
		$('#expent_reload').click(function() {
			$("#expent_datagrid").datagrid("load", {});
		});

		var url;
		/* 弹出添加窗口 */
		$('#expent_add').click(function() {
			$('#expent_edit_dlg').dialog('open').dialog('setTitle', '添加');
			url = 'expInsert';
		});
		/* 弹出编辑窗口 */
		$('#expent_edit').click(
				function() {
					var row = $('#expent_datagrid').datagrid('getSelected');
					if (row) {
						url = 'expUpdate?expId=' + row.expId;
						$('#expent_edit_dlg').dialog('open').dialog('setTitle',
								'编辑信息');
						$('#expent_edit_fm').form('load', row);
					} else {
						$.messager.alert('提示', '请选择数据！');
					}
				});
		$('#expent_edit_submit_button').click(function() {
			if (!$('#expent_edit_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$.messager.confirm('确认', '确认保存吗？', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : url,
						data : $('#expent_edit_fm').serialize(),
						success : function(data) {
							if (data.success) {
								$.messager.alert('提示', '保存成功！');
								$('#expent_edit_dlg').dialog('close');
								$("#expent_datagrid").datagrid("reload");
							} else {
								$.messager.alert('提示', '保存失败，请稍后再试！');
							}
						},
						error : function(request, error) {
							$.messager.alert('提示', '保存失败，请稍后再试！');
						}
					});
				} else {
					$('#expent_edit_dlg').dialog('close');
				}
				$('#expent_edit_fm').form('clear');
			});
		});

		/* 删除用户 */
		$('#expent_delete').click(function() {
			var row = $('#expent_datagrid').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '确认删除吗？', function(r) {
					if (r) {
						$.ajax({
							type : 'POST',
							url : 'expDelete',
							data : {
								expId : row.expId
							},
							success : function(data) {
								//var result = eval("(" + data + ")");
								if (data.success) {
									$.messager.alert('提示', '删除成功！');
									$("#expent_datagrid").datagrid("reload");
								} else {
									$.messager.alert('提示', '删除失败，请稍后再试！');
								}
							},
							error : function(request, error) {
								$.messager.alert('提示', '删除失败，请稍后再试！');
							}
						});
					}
				});
			} else {
				$.messager.alert('提示', '请选择数据！');
			}
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
				expEmpName : $('#expent_expEmpName').combobox('getText'),
				expDate : $('#expent_expDate').datebox('getValue')
			});
			$('#expent_search_dlg').dialog('close');
			$('#expent_search_fm').form('clear');
		});

		/* 验证函数 */
		$.extend($.fn.validatebox.defaults.rules, {
			maxLength : {
				validator : function(value, param) {
					return value.length <= param[0];
				},
				message : '输入内容长度必须不大于{0}'
			},
			number : {
				validator : function(value) {
					return /^\d+$/.test(value);
				},
				message : '输入内容必须为数字'
			},
		});
	</script>

</div>
