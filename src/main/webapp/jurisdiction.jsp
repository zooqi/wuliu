<%@ page language="java" pageEncoding="UTF-8"%>
<div class="easyui-panel" data-options="fit:true,border:false">
	<div align="center"
		style="margin: 20px auto auto 20px; font-weight: bold; font-size: 20px;">

		<p class="zooqi-head-text">员工权限信息管理</p>

	</div>
	<div style="margin: 20px 30px auto 30px;">
		<table id="jur_datagrid"></table>
		<!-- 工具栏按钮 -->
		<div id="jur_toolbar">
			<a id="jur_reload" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-reload',plain:true">显示所有</a><a id="jur_edit"
				href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit',plain:true">编辑</a><a
				id="jur_search" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true">搜索</a> 
		</div>
	</div>
	<!-- 对话框 -->
		<div id="jur_edit_dlg" class="easyui-dialog"
			style="padding: 0px 0px; width: 730px; height: 300px;"
			data-options="closed:true,buttons:'#jur_edit_dlg-buttons'">
			<form id="jur_edit_fm">
				<div id="jur_edit_tabs" class="easyui-tabs">
					<div title="权限管理基本信息">
						<table class="zooqi-frame-text" border="1"
							style="border-collapse: collapse; border: 2px solid #D6E3F4; margin-left: 3px; margin-right: 1px"
							cellspacing="35%" cellpadding="8">
							<tr>
								<td style="width: 40px; text-align: center;">职工号</td>
								<td><input id="jur_empNum1" name="empNum"
									style="width: 70px; text-align: center;"></td>
								<td style="width: 30px; text-align: center;">姓 名</td>
								<td><input id="jur_empName1" name="empName"
									style="width: 70px; text-align: center;"></td>
							</tr>
							<tr>
								<td></td>
								<td style="width: 50px; text-align: center">行政管理</td>
								<td></td>
								<td style="width: 50px; text-align: center">业务管理</td>
								<td></td>
								<td style="width: 50px; text-align: center" >财务管理</td>
								<td></td>
								<td style="width: 80px; text-align: center" >权限管理</td>
								<td></td>
								<td style="width: 80px; text-align: center">个人管理</td>
							</tr>
							<tr>
								<td style="width: 10px; text-align: center" ><input id="checkbox1" name="1" type="checkbox" value="1"></td>
								<td style="width: 80px; text-align: center" id="empInfor">员工管理</td>
								<td style="width: 10px; text-align: center" ><input id="checkbox2" name="3" type="checkbox" value="3"></td>
								<td style="width: 80px; text-align: center" id="deliver">发货管理</td>
								<td style="width: 10px; text-align: center" ><input id="checkbox3" name="6" type="checkbox" value="6"></td>
								<td style="width: 80px; text-align: center" id="expent">日常支出</td>
								<td style="width: 10px; text-align: center" ><input id="checkbox4" name="9" type="checkbox" value="9"></td>
								<td style="width: 80px; text-align: center" id="jurisdiction">授予权限</td>
								<td style="width: 10px; text-align: center" ><input id="checkbox5" name="10" type="checkbox" value="10"></td>
								<td style="width: 80px; text-align: center" id="person">个人信息</td>
							</tr>	
							<tr>
								<td style="width: 10px; text-align: center" ><input id="checkbox6" name="2" type="checkbox" value="2"></td>
								<td style="width: 80px; text-align: center" id="attentInfor">考勤管理</td>
								<td style="width: 10px; text-align: center" ><input id="checkbox7" name="4" type="checkbox" value="4"></td>
								<td style="width: 80px; text-align: center" id="arrival">到货管理</td>
								<td style="width: 10px; text-align: center" ><input id="checkbox8" name="7" type="checkbox" value="7"></td>
								<td style="width: 80px; text-align: center" id="income">业务收支</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td style="width: 10px; text-align: center" ><input id="checkbox9" name="5" type="checkbox" value="5"></td>
								<td style="width: 80px; text-align: center" id="traffic">车流管理</td>
								<td style="width: 10px; text-align: center" ><input  id="checkbox10" name="8" type="checkbox" value="8"></td>
								<td style="width: 80px; text-align: center" id="money">每月结余</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

	<!-- 搜索表单 -->
	<div id="jur_search_dlg" class="easyui-dialog"
		style="padding: 20px 50px;"
		data-options="closed:true,buttons:'#jur_search_dlg-buttons'">
		<form id="jur_search_fm">
			<table class="zooqi-frame-text" style="border-spacing: 10px;">
				<tr>
					<td width="70px">职 &nbsp;工 &nbsp;号：</td>
					<td><input id="jur_empNum" name="empNum1" class="easyui-validatebox"
						data-options="validType:'length[0,32]'" style="width: 110px"></td>
				</tr>

				<tr>
					<td width="70px">姓&emsp;&emsp;名：</td>
					<td><input id="jur_empName" name="empName1" class="easyui-validatebox"
						data-options="validType:'length[0,32]'" style="width: 110px"></td>
				</tr>
				<tr>
					<td width="70px">部&emsp;&emsp;门：</td>
					<td><input id="jur_empDepart" name="empDepaert" class="easyui-validatebox"
						data-options="validType:'length[0,64]'" style="width: 110px"></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="jur_search_dlg-buttons">
		<a id="jur_search_button" href="javascript:void(0)"
			class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
			style="width: 90px">搜索</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#jur_search_dlg').dialog('close');javascript:$('#jur_search_fm').form('clear');"
			style="width: 90px">取消</a>
	</div>

	<script type="text/javascript">
	
		$('#jur_datagrid').datagrid({
			url : 'empReach',//加载json数据的URL
			fitColumns : true,//自动调整每一列的宽度
			singleSelect : true,//一次只能选中一行
			pagination : true,//是否需要分页(如果true，则显示分页控件)
			rownumbers : true,//是否显示行号
			toolbar : '#jur_toolbar',//链接工具栏按钮
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
			}] ]
		});
		
		/* 显示所有 */
		$('#jur_reload').click(function() {
			$("#jur_datagrid").datagrid("load", {});
		});

		/* 弹出编辑窗口 */
		$('#jur_edit').click(function() {
			var row = $('#jur_datagrid').datagrid('getSelected');
			if (row) {
				$('#jur_edit_dlg').dialog('open').dialog('setTitle', '编辑信息');
				$.ajax({
					type : 'POST',
					url : 'jurGet?empId=' + row.empId,
					success : function(data) {
						for(var i=0;i<=data.length;i++) {
							if(data[i].empId==1 &&  data[i].funId==$('#checkbox1').val()){
								$("#checkbox1").prop("checked",true);
							}
							else if(data[i].empId==1 &&  data[i].funId==$('#checkbox2').val()){
								$("#checkbox2").prop("checked",true);
							}
							else if(data[i].empId==1 &&  data[i].funId==$('#checkbox3').val()){
								$("#checkbox3").prop("checked",true);
							}
							else if(data[i].empId==1 &&  data[i].funId==$('#checkbox4').val()){
								$("#checkbox4").prop("checked",true);
							}
							else if(data[i].empId==1 &&  data[i].funId==$('#checkbox5').val()){
								$("#checkbox5").prop("checked",true);
							}
							else if(data[i].empId==1 &&  data[i].funId==$('#checkbox6').val()){
								$("#checkbox6").prop("checked",true);
							}
							else if(data[i].empId==1 &&  data[i].funId==$('#checkbox7').val()){
								$("#checkbox7").prop("checked",true);
							}
							else if(data[i].empId==1 &&  data[i].funId==$('#checkbox8').val()){
								$("#checkbox8").prop("checked",true);
							}
							else if(data[i].empId==1 &&  data[i].funId==$('#checkbox9').val()){
								$("#checkbox9").prop("checked",true);
							}
							else if(data[i].empId==1 &&  data[i].funId==$('#checkbox10').val()){
								$("#checkbox10").prop("checked",true);
							}
						}
					}
				});
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
		$('#jur_search').click(function() {
			$('#jur_search_dlg').dialog('open').dialog('setTitle', '搜索员工信息');
		});
		/* 搜索 */
		$('#jur_search_button').click(function() {
			if (!$('#jur_search_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$('#jur_datagrid').datagrid('load', {
				empNum : $('#jur_empNum').val(),
				empName : $('#jur_empName').val(),
				empDepart : $('#jur_empDepart').val()
			});
			$('#jur_search_dlg').dialog('close');
			$('#jur_search_fm').form('clear');
		});
	</script>

</div>
