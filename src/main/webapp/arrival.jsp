<%@ page language="java" pageEncoding="UTF-8"%>

<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	margin: 0px auto;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 8px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 8px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}
</style>

<div id="arvgs_panel" class="easyui-panel"
	data-options="fit:true,border:false">

	<p class="zooqi-head-text"
		style="margin-top: 20px; text-align: center;">到货信息管理</p>

	<div style="margin: 20px 30px auto 30px;">
		<table id="arvgs_datagrid"></table>

		<!-- 工具栏按钮 -->
		<div id="arvgs_toolbar">
			<a id="arvgs_reload" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-reload',plain:true">显示所有</a> <a
				id="arvgs_edit" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit',plain:true">编辑</a> <a
				id="arvgs_delete" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-remove',plain:true">删除</a> <a
				id="arvgs_search" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true">搜索</a> <a
				id="arvgs_export" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-undo',plain:true">导入</a>
		</div>
	</div>

	<!-- Dialog -->
	<div id="arvgs_dlg" class="easyui-dialog"
		data-options="closed:true,buttons:'#arvgs_dlg-buttons'">
		<form id="arvgs_fm">
			<table class="tg" style="table-layout: fixed; width: 972px">
				<colgroup>
					<col style="width: 81px">
					<col style="width: 81px">
					<col style="width: 81px">
					<col style="width: 81px">
					<col style="width: 81px">
					<col style="width: 81px">
					<col style="width: 81px">
					<col style="width: 81px">
					<col style="width: 81px">
					<col style="width: 81px">
					<col style="width: 81px">
					<col style="width: 81px">
				</colgroup>
				<tr>
					<td class="tg-031e" colspan="3">到货日期：<input
						class="easyui-datebox" data-options="validType:'length[0,32]'"></td>
					<td class="tg-031e" colspan="3">货号：<input
						class="easyui-validatebox" name="goBank"
						data-options="validType:'length[0,64]'" style="width: 170px;"></td>
					<td class="tg-031e" colspan="3">起点：<input
						class="easyui-validatebox" name="logSiteStart" disabled="disabled"
						data-options="validType:'length[0,64]'" style="width: 170px;"></td>
					<td class="tg-031e" colspan="3">终点：<input
						class="easyui-validatebox" name="goSiteEnd"
						data-options="validType:'length[0,64]'" style="width: 170px;"></td>
				</tr>
				<tr>
					<td class="tg-031e" colspan="4">收货人：<input name="goForMan"
						class="easyui-validatebox" data-options="validType:'length[0,64]'"
						style="width: 235px;"></td>
					<td class="tg-031e" colspan="3">电话：<input name="goForPhone"
						class="easyui-validatebox" data-options="validType:'length[0,64]'"
						style="width: 170px;"></td>
					<td class="tg-031e" colspan="5">地址：<input name="goForAddress"
						class="easyui-validatebox" data-options="validType:'length[0,64]'"
						style="width: 330px;"></td>
				</tr>
				<tr>
					<td class="tg-031e" colspan="4">发货人：<input name="goSendMan"
						class="easyui-validatebox" data-options="validType:'length[0,64]'"
						style="width: 235px;"></td>
					<td class="tg-031e" colspan="3">电话：<input name="goSendPhone"
						class="easyui-validatebox" data-options="validType:'length[0,64]'"
						style="width: 170px;"></td>
					<td class="tg-031e" colspan="5">地址：<input name="goSendAddress"
						class="easyui-validatebox" data-options="validType:'length[0,64]'"
						style="width: 330px;"></td>
				</tr>
				<tr style="text-align: center;">
					<td class="tg-031e" colspan="2">货品名称</td>
					<td class="tg-031e">数量</td>
					<td class="tg-031e">包装样式</td>
					<td class="tg-031e">重量</td>
					<td class="tg-031e">体积</td>
					<td class="tg-031e">运费</td>
					<td class="tg-031e">保价费</td>
					<td class="tg-031e">代收货款</td>
					<td class="tg-031e">回扣</td>
					<td class="tg-031e">货款扣</td>
					<td class="tg-031e">中转费</td>
				</tr>
				<tr style="text-align: center;">
					<td class="tg-031e" colspan="2"><input
						class="easyui-validatebox" name="goName"
						data-options="validType:'length[0,64]'"></td>
					<td class="tg-031e"><input class="easyui-validatebox"
						name="goNum" data-options="validType:'length[0,32]'"
						style="width: 60px;"></td>
					<td class="tg-031e"><input class="easyui-validatebox"
						name="goPack" data-options="validType:'length[0,32]'"
						style="width: 60px;"></td>
					<td class="tg-031e"><input class="easyui-validatebox"
						name="goWeight" data-options="validType:'length[0,32]'"
						style="width: 60px;"></td>
					<td class="tg-031e"><input class="easyui-validatebox"
						name="goVolume" data-options="validType:'length[0,32]'"
						style="width: 60px;"></td>
					<td class="tg-031e"><input class="easyui-validatebox"
						name="goPay" data-options="validType:'length[0,32]'"
						style="width: 60px;"></td>
					<td class="tg-031e"><input class="easyui-validatebox"
						name="goInsurancePay" data-options="validType:'length[0,32]'"
						style="width: 60px;"></td>
					<td class="tg-031e"><input class="easyui-validatebox"
						name="goReplacePay" data-options="validType:'length[0,32]'"
						style="width: 60px;"></td>
					<td class="tg-031e"><input class="easyui-validatebox"
						name="goCommission" data-options="validType:'length[0,32]'"
						style="width: 60px;"></td>
					<td class="tg-031e"><input class="easyui-validatebox"
						name="goDamagePay" data-options="validType:'length[0,32]'"
						style="width: 60px;"></td>
					<td class="tg-031e"><input class="easyui-validatebox"
						name="goTransitPay" data-options="validType:'length[0,32]'"
						style="width: 60px;"></td>
				</tr>
				<tr>
					<td class="tg-031e" colspan="2">提货方式：<input
						class="easyui-validatebox" name="goGetWay"
						data-options="validType:'length[0,32]'" style="width: 65px;"></td>
					<td class="tg-031e" colspan="2">付款方式：<input
						class="easyui-validatebox" name="goPayWay"
						data-options="validType:'length[0,32]'" style="width: 65px;"></td>
					<td class="tg-031e" colspan="7">备注：<input
						class="easyui-validatebox" name="goRemark"
						data-options="validType:'length[0,32]'" style="width: 490px;"></td>
					<td class="tg-031e" style="text-align: center;">总计</td>
				</tr>
				<tr>
					<td class="tg-031e" colspan="3">发车日期：<input
						class="easyui-datebox" name="logSendDate" disabled="disabled"></td>
					<td class="tg-031e" colspan="4">起点：<input
						class="easyui-validatebox" name="logSiteStart" disabled="disabled"
						style="width: 250px;"></td>
					<td class="tg-031e" colspan="4">终点：<input
						class="easyui-validatebox" name="logSiteEnd" disabled="disabled"
						style="width: 250px;"></td>
					<td class="tg-031e" rowspan="2" style="text-align: center;"><input
						class="easyui-validatebox" name="goName" disabled="disabled"
						style="width: 60px;"></td>
				</tr>
				<tr>
					<td class="tg-031e" colspan="4">合同编号：<input
						class="easyui-validatebox" name="logContractNum"
						disabled="disabled" style="width: 220px;"></td>
					<td class="tg-031e" colspan="4">车牌：<input
						class="easyui-validatebox" name="logCarLicense"
						disabled="disabled" style="width: 250px;"></td>
					<td class="tg-031e" colspan="3">司机：<input
						class="easyui-validatebox" name="logCarDriver" disabled="disabled"
						style="width: 170px;"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="arvgs_dlg-buttons">
		<a id="arvgs_update_button" href="javascript:void(0)"
			class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
			style="width: 90px">保存</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#arvgs_dlg').dialog('close');"
			style="width: 90px">取消</a>
	</div>

	<script type="text/javascript">
		$('#arvgs_datagrid').datagrid({
			url : 'goodsReach',
			singleSelect : true,
			pagination : true,
			rownumbers : true,
			toolbar : '#arvgs_toolbar',
			remoteSort : false,

			columns : [ [ {
				field : 'goId',
				hidden : true
			}, {
				field : 'goType',
				hidden : true
			}, {
				field : 'logId',
				hidden : true
			}, {
				field : 'logContractNum',
				hidden : true
			}, {
				field : 'logSiteStart',
				hidden : true
			}, {
				field : 'logSiteEnd',
				hidden : true
			}, {
				title : '货号',
				field : 'goBank',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '货品名称',
				field : 'goName',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '司机',
				field : 'logCarDriver',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '车牌号',
				field : 'logCarLicense',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '发车日期',
				field : 'logSendDate',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '数量',
				field : 'goNum',
				align : 'center',
				sortable : true,
				width : 50
			}, {
				title : '包装样式',
				field : 'goPack',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '重量',
				field : 'goWeight',
				align : 'center',
				sortable : true,
				width : 50
			}, {
				title : '体积',
				field : 'goVolume',
				align : 'center',
				sortable : true,
				width : 50
			}, {
				title : '发货人',
				field : 'goSendMan',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '发货人电话',
				field : 'goSendPhone',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '发货人地址',
				field : 'goSendAddress',
				align : 'center',
				sortable : true,
				width : 150
			}, {
				title : '收货人',
				field : 'goForMan',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '收货人电话',
				field : 'goForPhone',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '收货人地址',
				field : 'goForAddress',
				align : 'center',
				sortable : true,
				width : 150
			}, {
				title : '提货方式',
				field : 'goGetWay',
				align : 'center',
				sortable : true,
				width : 80
			}, {
				title : '付款方式',
				field : 'goPayWay',
				align : 'center',
				sortable : true,
				width : 80
			}, {
				title : '运费',
				field : 'goPay',
				align : 'center',
				sortable : true,
				width : 80
			}, {
				title : '保价费',
				field : 'goInsurancePay',
				align : 'center',
				sortable : true,
				width : 80
			}, {
				title : '代收货款',
				field : 'goReplacePay',
				align : 'center',
				sortable : true,
				width : 80
			}, {
				title : '回扣',
				field : 'goCommission',
				align : 'center',
				sortable : true,
				width : 80
			}, {
				title : '货款扣',
				field : 'goDamagePay',
				align : 'center',
				sortable : true,
				width : 80
			}, {
				title : '中转费',
				field : 'goTransitPay',
				align : 'center',
				sortable : true,
				width : 80
			}, {
				title : '到站',
				field : 'goSiteEnd',
				align : 'center',
				sortable : true,
				width : 80
			}, {
				title : '备注',
				field : 'goRemark',
				align : 'center',
				sortable : true,
				width : 150
			} ] ],

			queryParams : {
				goType : 1
			}
		});

		/* 显示所有 */
		$('#arvgs_reload').click(function() {
			$('#arvgs_panel').panel('refresh', 'arrival.jsp');
		});

		var url;
		/* 弹出编辑对话框 */
		$('#arvgs_edit').click(function() {
			var row = $('#arvgs_datagrid').datagrid('getSelected');
			if (row) {
				$('#arvgs_dlg').dialog('open').dialog('setTitle', '编辑');
				$('#arvgs_fm').form('clear');
				$('#arvgs_fm').form('load', row);
				url = 'goodsUpdate?goId=' + row.goId;
			} else {
				$.messager.alert('提示', '请选择数据！');
			}
		});
		/* 保存 */
		$('#arvgs_update_button').click(function() {
			if (!$('#arvgs_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$.messager.confirm('确认', '确认保存吗？', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : url,
						data : $('#arvgs_fm').serialize(),
						success : function(data) {
							if (data.success) {
								$.messager.alert('提示', '保存成功！');
								$('#arvgs_dlg').dialog('close');
								$("#arvgs_datagrid").datagrid("reload");
							} else {
								$.messager.alert('提示', '保存失败，请稍后再试！');
							}
						},
						error : function(request, error) {
							$.messager.alert('提示', '保存失败，请稍后再试！');
						}
					});
				} else {
					$('#arvgs_dlg').dialog('close');
				}
			});
		});

		/* 删除 */
		$('#arvgs_delete').click(function() {
			var row = $('#arvgs_datagrid').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '确认删除吗？', function(r) {
					if (r) {
						$.ajax({
							type : 'POST',
							url : 'goodsDelete',
							data : {
								goId : row.goId
							},
							success : function(data) {
								if (data.success) {
									$.messager.alert('提示', '删除成功！');
									$("#arvgs_datagrid").datagrid("reload");
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

		/* 搜索功能按钮 */
		$('#arvgs_search').click(function() {
			$('#arvgs_search_dlg').dialog('open').dialog('setTitle', '搜索');
		});
		/* 搜索 */
		$('#arvgs_search_button').click(function() {
			if (!$('#arvgs_search_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$('#arvgs_datagrid').datagrid('load', {
				searchStudentNumber : $('#arvgs_search_studentNumber').val(),
				searchName : $('#arvgs_search_name').val(),
				searchSex : $('#arvgs_search_sex').combobox('getText'),
				searchMajor : $('#arvgs_search_major').val()
			});
			$('#arvgs_search_dlg').dialog('close');
		});

		/* 验证 */
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
			status : {
				validator : function(value) {
					return value == '正常' || value == '待验证' || value == '锁定'
							|| value == '过期';
				},
				message : '请选择正确的"状态"'
			},
			number : {
				validator : function(value) {
					return /^\d+$/.test(value);
				},
				message : '输入内容必须为数字'
			}
		});
	</script>
</div>
