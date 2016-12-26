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

<div id="dlvgs_panel" class="easyui-panel"
	data-options="fit:true,border:false">

	<p class="zooqi-head-text"
		style="margin-top: 20px; text-align: center;">发货管理</p>

	<div style="margin: 20px 30px auto 30px;">
		<table id="dlvgs_datagrid"></table>

		<!-- 工具栏按钮 -->
		<div id="dlvgs_toolbar">
			<a id="dlvgs_reload" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-reload',plain:true">显示所有</a> <a
				id="dlvgs_add" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:true">添加</a> <a
				id="dlvgs_edit" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit',plain:true">编辑</a> <a
				id="dlvgs_delete" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-remove',plain:true">删除</a> <a
				id="dlvgs_search" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true">搜索</a> <a
				id="dlvgs_export" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-undo',plain:true">导入</a>
		</div>
	</div>

	<!-- Add Dialog -->
	<div id="dlvgs_add_dlg" class="easyui-dialog"
		data-options="closed:true,buttons:'#dlvgs_add_dlg-buttons'">
		<form id="dlvgs_add_fm">
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
					<td class="tg-031e" colspan="3">发货日期：<input
						id="dlvgs_add_fm_lsd" class="easyui-datebox"
						data-options="validType:'length[0,32]'" style="width: 150px;"
						disabled="disabled"></td>
					<td class="tg-031e" colspan="3">货号：<input
						class="easyui-validatebox" name="goBank"
						data-options="validType:'length[0,64]'" style="width: 170px;"></td>
					<td class="tg-031e" colspan="3">起点：<input
						id="dlvgs_add_fm_lss" class="easyui-validatebox"
						name="logSiteStart" disabled="disabled"
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
						data-options="validType:'length[0,64]'" style="width: 140px;"></td>
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
					<td class="tg-031e" colspan="11" style="text-align: center;">车流：<select
						id="dlvgs_add_fm_selector" name="logId" class="easyui-combobox"
						data-options="{
							url : 'availableDepart',
							onSelect : function(record){
								$('#dlvgs_add_fm_lsd').datebox('setValue', record.logSendDate);
								$('#dlvgs_add_fm_lss').val(record.logSiteStart);
								$('#dlvgs_add_fm_lcn').val(record.logContractNum);
								$('#dlvgs_add_fm_lcl').val(record.logCarLicense);
								$('#dlvgs_add_fm_lcd').val(record.logCarDriver);
							}
						}"
						style="width: 650px;">
					</select></td>
					<td class="tg-031e" rowspan="2" style="text-align: center;"><input
						class="easyui-validatebox" name="goName" disabled="disabled"
						style="width: 60px;"></td>
				</tr>
				<tr>
					<td class="tg-031e" colspan="4">合同编号：<input
						id="dlvgs_add_fm_lcn" class="easyui-validatebox"
						name="logContractNum" disabled="disabled" style="width: 220px;"></td>
					<td class="tg-031e" colspan="4">车牌：<input
						id="dlvgs_add_fm_lcl" class="easyui-validatebox"
						name="logCarLicense" disabled="disabled" style="width: 250px;"></td>
					<td class="tg-031e" colspan="3">司机：<input
						id="dlvgs_add_fm_lcd" class="easyui-validatebox"
						name="logCarDriver" disabled="disabled" style="width: 170px;"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlvgs_add_dlg-buttons">
		<a id="dlvgs_add_button" href="javascript:void(0)"
			class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
			style="width: 90px">添加</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#dlvgs_add_dlg').dialog('close');"
			style="width: 90px">取消</a>
	</div>

	<!-- Edit Dialog -->
	<div id="dlvgs_dlg" class="easyui-dialog"
		data-options="closed:true,buttons:'#dlvgs_dlg-buttons'">
		<form id="dlvgs_fm">
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
					<td class="tg-031e" colspan="3">发货日期：<input name="logSendDate"
						class="easyui-datebox" data-options="validType:'length[0,32]'"
						style="width: 150px;" disabled="disabled"></td>
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
						data-options="validType:'length[0,64]'" style="width: 140px;"></td>
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
						class="easyui-datebox" name="logSendDate" style="width: 150px;"
						disabled="disabled"></td>
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
	<div id="dlvgs_dlg-buttons">
		<a id="dlvgs_update_button" href="javascript:void(0)"
			class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
			style="width: 90px">保存</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#dlvgs_dlg').dialog('close');"
			style="width: 90px">取消</a>
	</div>

	<script type="text/javascript">
		$('#dlvgs_datagrid').datagrid({
			url : 'goodsReach',
			singleSelect : true,
			pagination : true,
			rownumbers : true,
			toolbar : '#dlvgs_toolbar',
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
				title : '车牌',
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
				title : '终点',
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
				goType : 0
			}
		});

		/* 显示所有 */
		$('#dlvgs_reload').click(function() {
			$('#dlvgs_panel').panel('refresh', 'deliver.jsp');
		});

		/* 弹出添加对话框 */
		$('#dlvgs_add').click(function() {
			$('#dlvgs_add_dlg').dialog('open').dialog('setTitle', '添加');
			$('#dlvgs_add_fm').form('clear');
			$('#dlvgs_add_fm_selector').combobox('reload');
		});
		/* 保存 */
		$('#dlvgs_add_button').click(function() {
			if (!$('#dlvgs_add_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$.messager.confirm('确认', '确认添加吗？', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : 'goodsAdd?goType=0',
						data : $('#dlvgs_add_fm').serialize(),
						success : function(data) {
							if (data.success) {
								$.messager.alert('提示', '保存成功！');
								$('#dlvgs_add_dlg').dialog('close');
								$("#dlvgs_datagrid").datagrid("reload");
							} else {
								$.messager.alert('提示', '保存失败，请稍后再试！');
							}
						},
						error : function(request, error) {
							$.messager.alert('提示', '保存失败，请稍后再试！');
						}
					});
				} else {
					$('#dlvgs_add_dlg').dialog('close');
				}
			});
		});

		var url;
		/* 弹出编辑对话框 */
		$('#dlvgs_edit').click(function() {
			var row = $('#dlvgs_datagrid').datagrid('getSelected');
			if (row) {
				$('#dlvgs_dlg').dialog('open').dialog('setTitle', '编辑');
				$('#dlvgs_fm').form('clear');
				$('#dlvgs_fm').form('load', row);
				url = 'goodsUpdate?goId=' + row.goId;
			} else {
				$.messager.alert('提示', '请选择数据！');
			}
		});
		/* 保存 */
		$('#dlvgs_update_button').click(function() {
			if (!$('#dlvgs_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$.messager.confirm('确认', '确认保存吗？', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : url,
						data : $('#dlvgs_fm').serialize(),
						success : function(data) {
							if (data.success) {
								$.messager.alert('提示', '保存成功！');
								$('#dlvgs_dlg').dialog('close');
								$("#dlvgs_datagrid").datagrid("reload");
							} else {
								$.messager.alert('提示', '保存失败，请稍后再试！');
							}
						},
						error : function(request, error) {
							$.messager.alert('提示', '保存失败，请稍后再试！');
						}
					});
				} else {
					$('#dlvgs_dlg').dialog('close');
				}
			});
		});

		/* 删除 */
		$('#dlvgs_delete').click(function() {
			var row = $('#dlvgs_datagrid').datagrid('getSelected');
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
									$("#dlvgs_datagrid").datagrid("reload");
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
		$('#dlvgs_search').click(function() {
			$('#dlvgs_search_dlg').dialog('open').dialog('setTitle', '搜索');
		});
		/* 搜索 */
		$('#dlvgs_search_button').click(function() {
			if (!$('#dlvgs_search_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$('#dlvgs_datagrid').datagrid('load', {});
			$('#dlvgs_search_dlg').dialog('close');
		});
	</script>
</div>
