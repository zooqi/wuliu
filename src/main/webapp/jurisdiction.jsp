<%@ page language="java" pageEncoding="UTF-8"%>
<div class="easyui-panel" data-options="fit:true,border:false">
	<div align="center"
		style="margin: 20px auto auto 20px; font-weight: bold; font-size: 20px;">

	</div>
	<div style="margin: 20px 30px auto 30px;">
		<table id="jur_datagrid"></table>
		<!-- 工具栏按钮 -->
		<div id="jur_toolbar">
			<a id="jur_reload" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-reload',plain:true">显示所有</a><a
				id="jur_edit" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit',plain:true">编辑</a> <a
				id="jur_search" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true">搜索</a>
		</div>
		<!-- 对话框 -->
		<div id="jur_edit_dlg" class="easyui-dialog"
			style="padding: 0px 0px; width: 680px; height: 330px;"
			data-options="closed:true,buttons:'#jur_edit_dlg-buttons'">
			<form id="jur_edit_fm">
				<div id="jur_edit_tabs" class="easyui-tabs">
					<div title="权限管理基本信息">
						<table class="zooqi-frame-text" border="1"
							style="border-collapse: collapse; border: 2px solid #D6E3F4; margin-left: 3px; margin-right: 1px"
							cellspacing="35%" cellpadding="8">
							<tr>
								<td style="width: 93px; text-align: center;">职&nbsp;工&nbsp;号：</td>
								<td><input id="jur_empNum1" name="empNum"
									style="width: 120px"></td>
								<td style="width: 93px; text-align: center;">姓&emsp;&emsp;名</td>
								<td><input id="jur_empName1" name="empName"
									style="width: 113px"></td>
							</tr>
							<tr>
								<td style="width: 93px; text-align: center" id="checkbox1"><input type="checkbox"></td>
								<td style="width: 93px; text-align: center" id="menuName">菜单名称</td>
								<td style="width: 93px; text-align: center" id="checkbox2"><input type="checkbox"></td>
								<td style="width: 93px; text-align: center" id="funName">功能名称</td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>

		<!-- 按钮 -->
		<div id="jur_edit_dlg-buttons">
			<a id="jur_edit_submit_button" href="javascript:void(0)"
				class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
				style="width: 90px">保存</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
				onclick="javascript:$('#jur_edit_dlg').dialog('close');$('#jur_edit_fm').form('clear');"
				style="width: 90px">取消</a>
		</div>
	</div>

	<!-- 搜索表单 -->
	<div id="jur_search_dlg" class="easyui-dialog"
		style="padding: 0px 0px; width: 250px; height: 200px;"
		data-options="closed:true,buttons:'#jur_search_dlg-buttons'">
		<form id="jur_search_fm">
			<table class="zooqi-frame-text" style="border-spacing: 10px;">
				<tr>
					<td width="70px">职 &nbsp;工 &nbsp;号：</td>
					<td><input id="jur_empNum" name="empNum"
						style="width: 114px"></td>
				</tr>
				<tr>
					<td width="70px">员工姓名：</td>
					<td><input id="jur_empName" name="empName"
						style="width: 114px"></td>
				</tr>
				<tr>
					<td width="70px">所在部门：</td>
					<td><input id="jur_empDepart" name="empDepart"
						style="width: 114px"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="jur_search_dlg-buttons">
		<a id="jur_search_button" href="javascript:void(0)"
			class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
			style="width: 90px">搜索</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#jur_search_dlg').dialog('close')"
			style="width: 90px">取消</a>
	</div>

	<script type="text/javascript">
		$('#jur_datagrid').datagrid({
			url : 'empReach',
			fitColumns : true,
			singleSelect : true,
			pagination : true,
			rownumbers : true,
			toolbar : '#jur_toolbar',
			remoteSort : false,
			columns : [ [ {
				field : 'empId',
				hidden : true
			}, {
				title : '职工号',
				field : 'empNum',
				align : 'center',
				sortable : true,
				width : 150
			}, {
				title : '姓名',
				field : 'empName',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '部门',
				field : 'empDepart',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '职位',
				field : 'empPosition',
				align : 'center',
				sortable : true,
				width : 140
			}] ]
		});

		/* 显示所有 */
		$('#jur_reload').click(function() {
			$("#jur_datagrid").datagrid("load", {});
		});
		
		/* 加载菜单 */
		$('#jur_edit').click(
				function() {
					var row = $('#jur_datagrid').datagrid('getSelected');
					if (row) {
						url = 'jurReach?empId'+row.empId;
						$('#jur_edit_dlg').dialog('open').dialog('setTitle',
								'编辑信息');
						$('#jur_edit_fm').form('load', row);
					} else {
						$.messager.alert('提示', '请选择数据！');
					}
				});
		
		var url;
		/* 弹出编辑窗口 */
		$('#jur_edit').click(
				function() {
					var row = $('#jur_datagrid').datagrid('getSelected');
					if (row) {
						url = 'jurReach';
						$('#jur_edit_dlg').dialog('open').dialog('setTitle',
								'编辑信息');
						$('#jur_edit_fm').form('load', row);
					} else {
						$.messager.alert('提示', '请选择数据！');
					}
				});
		$('#jur_edit_submit_button').click(function() {
			if (!$('#jur_edit_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$.messager.confirm('确认', '确认保存吗？', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : url,
						data : $('#jur_edit_fm').serialize(),
						success : function(data) {
							if (data.success) {
								$.messager.alert('提示', '保存成功！');
								$('#jur_edit_dlg').dialog('close');
								$("#jur_datagrid").datagrid("reload");
							} else {
								$.messager.alert('提示', '保存失败，请稍后再试！');
							}
						},
						error : function(request, error) {
							$.messager.alert('提示', '保存失败，请稍后再试！');
						}
					});
				} else {
					$('#jur_edit_dlg').dialog('close');
				}
				$('#jur_edit_fm').form('clear');
			});
		});

		/*弹出搜索窗口*/
		$('#jur_search').click(
				function() {
					$('#jur_search_dlg').dialog('open').dialog('setTitle',
							'搜索支出信息');
				});
		/* 搜索 */
		$('#jur_search_button').click(function() {
			if (!$('#jur_search_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$('#jur_datagrid').datagrid('load', {
				expEmpNum : $('#jur_empNum').val(),
				expEmpName : $('#jur_empName').val()
			});
			$('#jur_search_dlg').dialog('close');
			$('#jur_search_fm').form('clear');
		});
	</script>

</div>
