<%@ page language="java" pageEncoding="UTF-8"%>
<div class="easyui-panel" data-options="fit:true,border:false">
	<div align="center"
		style="margin: 20px auto auto 20px; font-weight: bold; font-size: 20px;">

		<p class="zooqi-head-text">员工信息管理</p>

	</div>
	<div style="margin: 20px 30px auto 30px;">
		<table id="emp_datagrid"></table>
		<!-- 工具栏按钮 -->
		<div id="emp_toolbar">
			<a id="emp_reload" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-reload',plain:true">显示所有</a> <a
				id="emp_add" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:true">添加</a> <a id="emp_edit"
				href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit',plain:true">编辑</a> <a
				id="emp_delete" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-remove',plain:true">删除</a> <a
				id="emp_search" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true">搜索</a> 
			<!-- 
				<a id="emp_password" href="javascript:void(0)" class="easyui-linkbutton" 
				data-options="iconCls:'icon-tip',plain:true">修改密码</a> 
				
				<a
				id="emp_export" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-save',plain:true">导出此页</a>
			-->
		</div>
		<!-- 对话框 -->
		<div id="emp_edit_dlg" class="easyui-dialog"
			style="padding: 0px 0px; width: 602px; height: 431px;"
			data-options="closed:true,buttons:'#emp_edit_dlg-buttons'">
			<form id="emp_edit_fm">
				<div id="emp_edit_tabs" class="easyui-tabs">
					<div title="员工基本信息">
						<table class="zooqi-frame-text" border="1"
							style="border-collapse: collapse; border: 2px solid #D6E3F4; margin-left: 3px; margin-right: 1px"
							cellspacing="35%" cellpadding="8">
							<tr>
								<td style="width: 93px; text-align: center;">职 &nbsp;工
									&nbsp;号：</td>
								<td style="width: 160px;"><input name="empNum"
									class="easyui-validatebox"
									data-options="required:true,validType:'length[0,32]'"
									style="width: 140px"></td>
								<td style="width: 93px; text-align: center;">姓&emsp;&emsp;名：</td>
								<td style="width: 160px;"><input name="empName"
									class="easyui-validatebox"
									data-options="required:true,validType:'length[0,32]'"
									style="width: 140px"></td>
							</tr>
							<tr>
								<td style="width: 93px; text-align: center;">部&emsp;&emsp;门：</td>
								<td><input class="easyui-validatebox" name="empDepart"
									data-options="validType:'length[0,32]'" style="width: 140px"></td>
								<td style="width: 93px; text-align: center;">职&emsp;&emsp;位：</td>
								<td><input class="easyui-validatebox" name="empPosition"
									data-options="validType:'length[0,32]'" style="width: 140px"></td>
							</tr>
							<tr>
								<td style="width: 93px; text-align: center;">基本工资：</td>
								<td><input class="easyui-validatebox" name="empWage"
									data-options="validType:'length[0,32]'" style="width: 140px"></td>
								<td style="width: 93px; text-align: center;">入职日期：</td>
								<td><input class="easyui-datebox" name="empDate"
									data-options="validType:'length[0,32]'" style="width: 144px"></td>
							</tr>
							<tr>
								<td style="width: 93px; text-align: center;">学&emsp;&emsp;历：</td>
								<td><select class="easyui-combobox" name="empEdu"
									data-options="validType:'length[0,32]'"
									style="width: 144px; height: 23px">
										<option value="   "></option>
										<option value="中专">中专</option>
										<option value="大专">大专</option>
										<option value="本科">本科</option>
										<option value="硕士">硕士</option>
										<option value="博士">博士</option>
										<option value="其他">其他</option>
								</select></td>
								<td style="width: 93px; text-align: center;">性&emsp;&emsp;别：</td>
								<td><select class="easyui-combobox" name="empSex"
									data-options="validType:'length[0,32]'"
									style="width: 144px; height: 23px">
										<option value="   "></option>
										<option value="男">男</option>
										<option value="女">女</option>
								</select></td>
							</tr>
							<tr>
								<td style="width: 93px; text-align: center;">生&emsp;&emsp;日：</td>
								<td><input class="easyui-datebox" name="empBorn"
									data-options="validType:'length[0,32]'" style="width: 144px"></td>
								<td style="width: 93px; text-align: center;">手机号码：</td>
								<td><input class="easyui-validatebox" name="empPhone"
									data-options="validType:'length[0,32]'" style="width: 140px">
								</td>
							</tr>
							<tr>
								<td style="width: 93px; text-align: center;">Q&emsp;&emsp;Q：</td>
								<td><input class="easyui-validatebox" name="empQQ"
									data-options="validType:'length[0,32]'" style="width: 140px;"></td>
								<td style="width: 93px; text-align: center;">健康状况：</td>
								<td><select class="easyui-combobox" name="empHealth"
									data-options="validType:'length[0,32]'"
									style="width: 144px; height: 23px">
										<option value="   "></option>
										<option value="健康">健康</option>
										<option value="亚健康">亚健康</option>
								</select></td>
							</tr>
							<tr>
								<td style="width: 93px; text-align: center;">婚姻状况：</td>
								<td><select class="easyui-combobox" name="empMarriage"
									data-options="validType:'length[0,32]'"
									style="width: 144px; height: 23px">
										<option value="   "></option>
										<option value="未婚">未婚</option>
										<option value="已婚">已婚</option>
										<option value="离异">离异</option>
								</select></td>
								<td style="width: 93px; text-align: center;">住&emsp;&emsp;址：</td>
								<td><input class="easyui-validatebox" name="empAddress"
									data-options="validType:'length[0,32]'" style="width: 140px">
								</td>
							</tr>
							<tr>
								<td style="width: 93px; text-align: center;">密&emsp;&emsp;码：</td>
								<td><input class="easyui-validatebox" name="empPasswd"
									data-options="required:true,validType:'length[0,32]'"
									style="width: 140px"></td>
								<td style="width: 93px; text-align: center;">备&emsp;&emsp;注：</td>
								<td><input class="easyui-validatebox" name="empRemark"
									data-options="validType:'length[0,32]'" style="width: 140px"></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
		<!-- 按钮 -->
		<div id="emp_edit_dlg-buttons">
			<a id="emp_edit_submit_button" href="javascript:void(0)"
				class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
				style="width: 90px">保存</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
				onclick="javascript:$('#emp_edit_dlg').dialog('close');$('#emp_edit_fm').form('clear');"
				style="width: 90px">取消</a>
		</div>
	</div>

	<!-- 搜索表单 -->
	<div id="emp_search_dlg" class="easyui-dialog"
		style="padding: 20px 50px;"
		data-options="closed:true,buttons:'#emp_search_dlg-buttons'">
		<form id="emp_search_fm">
			<table class="zooqi-frame-text" style="border-spacing: 10px;">
				<tr>
					<td width="70px">职 &nbsp;工 &nbsp;号：</td>
					<td><input id="emp_empNum" class="easyui-validatebox"
						data-options="validType:'length[0,32]'" style="width: 110px"></td>
				</tr>

				<tr>
					<td width="70px">姓&emsp;&emsp;名：</td>
					<td><input id="emp_empName" class="easyui-validatebox"
						data-options="validType:'length[0,32]'" style="width: 110px"></td>
				</tr>

				<tr>
					<td width="70px">性&emsp;&emsp;别：</td>
					<td><select id="emp_empSex" class="easyui-combobox"
						data-options="validType:'sex'" style="width: 114px;">
							<option value=""></option>
							<option value="男">男</option>
							<option value="女">女</option>
					</select></td>
				</tr>

				<tr>
					<td width="70px">部&emsp;&emsp;门：</td>
					<td><input id="emp_empDepart" class="easyui-validatebox"
						data-options="validType:'length[0,64]'" style="width: 110px"></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="emp_search_dlg-buttons">
		<a id="emp_search_button" href="javascript:void(0)"
			class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
			style="width: 90px">搜索</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#emp_search_dlg').dialog('close');javascript:$('#emp_search_fm').form('clear');"
			style="width: 90px">取消</a>
	</div>

	<!-- 修改密码表单 -->
	<!--  
	<div id="emp_cgpwd_dlg" class="easyui-dialog"
		style="padding: 20px 50px;"
		data-options="closed:true,buttons:'#emp_cgpwd_dlg-buttons'">
		<form id="emp_cgpwd_fm">
			<table class="zooqi-frame-text" style="border-spacing: 10px;">
				<tr>
					<td width="65px">新 &nbsp;密 &nbsp;码：</td>
					<td><input id="emp_newPassword" class="easyui-validatebox"
						type="password"
						data-options="required:true,validType:'length[6,32]'"
						style="width: 220px"></td>
				</tr>
				<tr>
					<td width="65px">确认密码：</td>
					<td><input id="emp_confirmPassword" class="easyui-validatebox"
						type="password"
						data-options="required:true,validType:'length[6,32]'"
						style="width: 220px"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="emp_cgpwd_dlg-buttons">
		<a id="emp_cgpwd_button" href="javascript:void(0)"
			class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
			style="width: 90px">修改</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#emp_cgpwd_dlg').dialog('close')"
			style="width: 90px">取消</a>
	</div>
-->

	<script type="text/javascript">
	
		$('#emp_datagrid').datagrid({
			url : 'empReach',//加载json数据的URL
			fitColumns : true,//自动调整每一列的宽度
			singleSelect : true,//一次只能选中一行
			pagination : true,//是否需要分页(如果true，则显示分页控件)
			rownumbers : true,//是否显示行号
			toolbar : '#emp_toolbar',//链接工具栏按钮
			remoteSort : false,//是否远程排序

			columns : [ [ {
				field : 'empId',
				hidden : true
			}, {
				title : '职工号',
				field : 'empNum',
				align : 'center',
				sortable : true,//可排序
				width : 110
			}, {
				title : '姓名',
				field : 'empName',
				align : 'center',
				sortable : true,
				width : 130
			}, {
				title : '部门',
				field : 'empDepart',
				align : 'center',
				sortable : true,
				width : 140
			}, {
				title : '职位',
				field : 'empPosition',
				align : 'center',
				sortable : true,
				width : 140
			}, {
				title : '基本工资',
				field : 'empWage',
				align : 'center',
				sortable : true,
				width : 110
			}, {
				title : '入职日期',
				field : 'empDate',
				align : 'center',
				sortable : true,
				width : 140
			}, {
				title : '学历',
				field : 'empEdu',
				align : 'center',
				sortable : true,
				width : 40
			}, {
				title : '性别',
				field : 'empSex',
				align : 'center',
				sortable : true,
				width : 20
			}, {
				title : '生日',
				field : 'empBorn',
				align : 'center',
				sortable : true,
				width : 140
			}, {
				title : '手机号码',
				field : 'empPhone',
				align : 'center',
				sortable : true,
				width : 180
			}, {
				title : 'QQ',
				field : 'empQQ',
				align : 'center',
				sortable : true,
				width : 180
			}, {
				title : '健康',
				field : 'empHealth',
				align : 'center',
				sortable : true,
				width : 85
			}, {
				title : '婚姻',
				field : 'empMarriage',
				align : 'center',
				sortable : true,
				width : 30
			}, {
				title : '住址',
				field : 'empAddress',
				align : 'center',
				sortable : true,
				width : 250
			}, {
				title : '备注',
				field : 'empRemark',
				align : 'center',
				sortable : true,
				width : 100
			} ] ]
		});
		
		/* 显示所有 */
		$('#emp_reload').click(function() {
			$("#emp_datagrid").datagrid("load", {});
		});

		var url;
		/* 弹出添加窗口 */
		$('#emp_add').click(function() {
			$('#emp_edit_dlg').dialog('open').dialog('setTitle', '添加');
			url = 'empAdd';
		});
		
		/* 弹出编辑窗口 */
		$('#emp_edit').click(function() {
			var row = $('#emp_datagrid').datagrid('getSelected');
			if (row) {
				url = 'empUpdate?empId=' + row.empId;
				$('#emp_edit_dlg').dialog('open').dialog('setTitle', '编辑信息');
				$('#emp_edit_fm').form('load', row);
			} else {
				$.messager.alert('提示', '请选择数据！');
			}
		});
		$('#emp_edit_submit_button').click(function() {
			if (!$('#emp_edit_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$.messager.confirm('确认', '确认保存吗？', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : url,
						data : $('#emp_edit_fm').serialize(),
						success : function(data) {
							if (data.success) {
								$.messager.alert('提示', '保存成功！');
								$('#emp_edit_dlg').dialog('close');
								$("#emp_datagrid").datagrid("reload");
							} else {
								$.messager.alert('提示', '保存失败，请稍后再试！');
							}
						},
						error : function(request, error) {
							$.messager.alert('提示', '保存失败，请稍后再试！');
						}
					});
				} else {
					$('#emp_edit_dlg').dialog('close');
				}
				$('#emp_edit_fm').form('clear');
			});
		});

		/* 删除用户 */
		$('#emp_delete').click(function() {
			var row = $('#emp_datagrid').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '确认删除吗？', function(r) {
					if (r) {
						$.ajax({
							type : 'POST',
							url : 'empDelete',
							data : {
								empId : row.empId
							},
							success : function(data) {
								//var result = eval("(" + data + ")");
								if (data.success) {
									$.messager.alert('提示', '删除成功！');
									$("#emp_datagrid").datagrid("reload");
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
		$('#emp_search').click(function() {
			$('#emp_search_dlg').dialog('open').dialog('setTitle', '搜索员工信息');
		});
		
		/* 搜索 */
		$('#emp_search_button').click(function() {
			if (!$('#emp_search_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$('#emp_datagrid').datagrid('load', {
				empNum : $('#emp_empNum').val(),
				empName : $('#emp_empName').val(),
				empSex : $('#emp_empSex').combobox('getText'),
				empDepart : $('#emp_empDepart').val()
			});
			$('#emp_search_dlg').dialog('close');
			$('#emp_search_fm').form('clear');
		});
		
		/*弹出修改密码窗口*/
		/*
		var cgpwd_id;
		$('#emp_password').click(function() {
			var row = $('#emp_datagrid').datagrid('getSelected');
			if (row) {
				cgpwd_id = row.empId;
				$('#emp_cgpwd_dlg').dialog('open').dialog('setTitle', '修改密码');
			} else {
				$.messager.alert('提示', '请选择数据！');
			}
		});
		*/
		/* 修改密码 */
		/*
		$('#emp_cgpwd_button').click(function() {
			var new_password = $('#emp_newPassword').val();
			var confirm_password = $('#emp_confirmPassword').val();
			if (!$('#emp_cgpwd_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			if (new_password != confirm_password) {
				$.messager.alert('提示', '"新密码"和"确认密码"不一致！');
				return;
			}
			$.messager.confirm('确认', '确认修改吗？', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : 'empPasswd',
						data : {
							empId : cgpwd_id,
							empPasswd : new_password
						},
						success : function(data) {
							var result = eval("(" + data + ")");
							if (result.success) {
								$.messager.alert('提示', '修改成功！');
								$('#emp_cgpwd_dlg').dialog('close');
							} else {
								$.messager.alert('提示', '修改失败，请稍后再试！');
							}
						},
						error : function(request, error) {
							$.messager.alert('提示', '修改失败，请稍后再试！');
						}
					});
				} else {
					$('#emp_cgpwd_dlg').dialog('close');
				}
			});
		});
*/
		/* 验证函数 */
		$.extend($.fn.validatebox.defaults.rules, {
			maxLength : {
				validator : function(value, param) {
					return value.length <= param[0];
				},
				message : '输入内容长度必须不大于{0}'
			},
			sex : {
				validator : function(value) {
					return value == '男' || value == '女';
				},
				message : '性别必须为"男"或"女"'
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
