<%@ page language="java" pageEncoding="UTF-8"%>
<div class="easyui-panel" data-options="fit:true,border:false">
	<div align="center"
		style="margin: 20px auto auto 20px; font-weight: bold; font-size: 20px;">

		<p class="zooqi-head-text">发货信息管理</p>

	</div>

	<div style="margin: 20px 30px auto 30px;">
		<table id="deliver_datagrid"></table>
		<!-- 工具栏按钮 -->
		<div id="deliver_toolbar">
			<a id="deliver_reload" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-reload',plain:true">显示所有</a> <a
				id="deliver_add" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:true">添加</a> <a
				id="deliver_edit" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit',plain:true">编辑</a> <a
				id="deliver_delete" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-remove',plain:true">删除</a> <a
				id="deliver_search" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true">搜索</a> 
				<a id="deliver_print" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-print',plain:true">打印预览</a>
				<a id="deliver_input" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-undo',plain:true">数据导出</a>
		</div>
	</div>
		<!-- 对话框 -->
		<div id="deliver_edit_dlg" class="easyui-dialog"
			style="padding: 0px 0px; width: 805px; height: 380px;"
			data-options="closed:true,buttons:'#deliver_edit_dlg-buttons'">
			<div id="other" style="margin: 20px auto auto 20px;">
		
			</div>
			<form id="deliver_edit_fm">
				<div id="deliver_edit_tabs" class="easyui-tabs">
					<div title="货物基本信息">
						<table class="zooqi-frame-text" border="1"
							style="border-collapse: collapse; border: 1px solid #D6E3F4; margin-left: 3px; margin-right: 1px"
							cellspacing="35%" cellpadding="8">
							<table
								style="border-collapse: collapse; border: 0px solid #D6E3F4; margin-left: 3px; margin-right: 1px"
								cellspacing="35%" cellpadding="8">
								<tr>
									<th style="width: 85px; text-align: center;">货运日期：</th>
									<td><input class="easyui-datebox" name="logSendDate"
										data-options="validType:'length[0,32]'" style="width: 104px">
									</td>
									<th style="width: 90px; text-align: center;">起 &nbsp;始
										&nbsp;地：</th>
									<td><input class="easyui-validatebox" name="goSiteStart"
										data-options="validType:'length[0,32]'" style="width: 90px">
									</td>
									<th style="width: 90px; text-align: center;">到 &nbsp;达
										&nbsp;地：</th>
									<td><input class="easyui-validatebox" name="goSiteEnd"
										data-options="validType:'length[0,32]'" style="width: 90px">
									</td>
									<th style="width: 90px; text-align: center;">货&emsp;&emsp;号：</th>
									<td><input class="easyui-validatebox" name="goBank"
										data-options="validType:'length[0,32]'" style="width: 90px">
									</td>
								</tr>
							</table>
							<table border="1"
								style="border-collapse: collapse; border: 0px solid #D6E3F4; margin-left: 3px; margin-right: 1px"
								cellspacing="35%" cellpadding="8">
								<tr>
									<th style="width: 93px; text-align: center;">收货单位：</th>
									<td style="width: 140px;"><input name="goForMan"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 120px"></td>
									<th style="width: 93px; text-align: center;">电&emsp;&emsp;话：</th>
									<td style="width: 160px;"><input name="goForPhone"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 140px"></td>
									<th style="width: 93px; text-align: center;">地&emsp;&emsp;址：</th>
									<td style="width: 160px;"><input name="goForAddress"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 140px"></td>
								</tr>
								<tr>
									<th style="width: 93px; text-align: center;">发货单位：</th>
									<td style="width: 140px;"><input name="goSendMan"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 120px"></td>
									<th style="width: 93px; text-align: center;">电&emsp;&emsp;话：</th>
									<td style="width: 160px;"><input name="goSendPhone"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 140px"></td>
									<th style="width: 93px; text-align: center;">地&emsp;&emsp;址：</th>
									<td style="width: 160px;"><input name="goSendAddress"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 140px"></td>
								</tr>
							</table>
							<table border="1"
								style="border-collapse: collapse; border: 0px solid #D6E3F4; margin-left: 3px; margin-right: 1px"
								cellspacing="35%" cellpadding="8">
								<tr>
									<th style="width: 150px; text-align: center;">货物全称</th>
									<th style="width: 50px; text-align: center;">数&emsp;&emsp;量</th>
									<th style="width: 50px; text-align: center;">包&emsp;&emsp;装</th>
									<th style="width: 50px; text-align: center;">重 &nbsp;量&nbsp;T</th>
									<th style="width: 50px; text-align: center;">体 &nbsp;积
										&nbsp;M</th>
									<th style="width: 50px; text-align: center;">保 &nbsp;价
										&nbsp;费</th>
									<th style="width: 50px; text-align: center;">货物运费</th>
									<th style="width: 50px; text-align: center;">付款方式</th>
									<th style="width: 50px; text-align: center;">提货方式</th>
								</tr>
								<tr>
									<td style="width: 150px;"><input name="goName"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 150px">
									</td>
									<td style="width: 50px;"><input name="goNum"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 50px">
									</td>
									<td style="width: 50px;"><input name="goPack"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 50px">
									</td>
									<td style="width: 54px;"><input name="goWeight"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 54px">
									</td>
									<td style="width: 50px;"><input name="goVolume"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 50px">
									</td>
									<td style="width: 50px;"><input name="goInsurancePay"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 50px">
									</td>
									<td style="width: 50px;"><input name="goPay"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 50px">
									</td>
									<td style="width: 70px;"><input name="goPayWay"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 70px">
									</td>
									<td style="width: 70px;"><input name="goGetPay"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 70px">
									</td>
								</tr>
							</table>
							<table border="1"
								style="border-collapse: collapse; border: 0px solid #D6E3F4; margin-left: 3px; margin-right: 1px"
								cellspacing="35%" cellpadding="8">
								<tr>
									<th style="width: 100px; text-align: center;">代收货款</th>
									<td style="width: 100px;"><input name="goReplacePay"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 100px">
									</td>
									<th style="width: 100px; text-align: center;">合计：</th>
									<td style="width: 400px;"><input name="goSum"
										class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 408px">
									</td>
								</tr>
								<tr>
									<th style="width: 100px; text-align: center;">备注：</th>

									<td style="width: 450px;" colspan="3"><input
										name="goRemark" class="easyui-validatebox"
										data-options="validType:'length[0,32]'" style="width: 558px">
									</td>

								</tr>
							</table>
						</table>
					</div>
				</div>
			</form>
		</div>
		<!-- 按钮 -->
		<div id="deliver_edit_dlg-buttons">
			<a id="deliver_edit_submit_button" href="javascript:void(0)"
				class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
				style="width: 90px">保存</a> 
			<a href="javascript:void(0)"
				class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
				onclick="javascript:$('#deliver_edit_dlg').dialog('close');$('#deliver_edit_fm').form('clear');"
				style="width: 90px">取消</a>
		</div>
	</div>

	<!-- 搜索表单 -->
	<div id="deliver_search_dlg" class="easyui-dialog"
		style="padding: 20px 50px;"
		data-options="closed:true,buttons:'#deliver_search_dlg-buttons'">
		<form id="deliver_search_fm">
			<table class="zooqi-frame-text" style="border-spacing: 10px;">
				<tr>
					<td width="70px">车 &nbsp;牌 &nbsp;号：</td>
					<td><input id="deliver_carLicence" class="easyui-validatebox"
						name="logCarLicence" data-options="validType:'length[0,32]'"
						style="width: 110px"></td>
				</tr>

				<tr>
					<td width="70px">发车日期：</td>
					<td><input id="deliver_logSendDate" class="easyui-validatebox"
						name="logSendDate" data-options="validType:'length[0,32]'"
						style="width: 110px"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="deliver_search_dlg-buttons">
		<a id="deliver_search_button" href="javascript:void(0)"
			class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
			style="width: 90px">搜索</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#deliver_search_dlg').dialog('close')"
			style="width: 90px">取消</a>
	</div>

	<!-- 导入表单 -->
	<div id="deliver_input_dlg" class="easyui-dialog"
		style="padding: 20px 50px;"
		data-options="closed:true,buttons:'#deliver_input_dlg-buttons'">
		<form id="deliver_input_fm">
			<table class="zooqi-frame-text" style="border-spacing: 10px;">
				<tr>
					<td>物流清单：<input class="easyui-filebox" style="width:300px">
				</tr>
			</table>
		</form>
	</div>
	<div id="deliver_input_dlg-buttons">
		<a id="deliver_input_button" href="javascript:void(0)"
			class="easyui-linkbutton c6" data-options="iconCls:'icon-ok'"
			style="width: 90px">导入</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#deliver_input_dlg').dialog('close')"
			style="width: 90px">取消</a>
	</div>

	<script type="text/javascript">
	
	/* 记录搜索按钮的点击状态 */
	var isAllNotNullStr = false;
	var isSearchBtnClicked = false;
		$("#other").hide();
		$('#deliver_datagrid').datagrid({
			url : 'goodsReach',
			fitColumns : true,
			singleSelect : true,
			pagination : true,
			rownumbers : true,
			toolbar : '#deliver_toolbar',
			remoteSort : false,

			columns : [ [ {
				field : 'goId',
				hidden : true
			}, {
				title : '货号',
				field : 'goBank',
				align : 'center',
				sortable : true,
				width : 110
			}, {
				title : '货名',
				field : 'goName',
				align : 'center',
				sortable : true,
				width : 130
			}, {
				title : '数量',
				field : 'goNum',
				align : 'center',
				sortable : true,
				width : 30
			}, {
				title : '重量',
				field : 'goWeight',
				align : 'center',
				sortable : true,
				width : 30
			}, {
				title : '体积',
				field : 'goVolume',
				align : 'center',
				sortable : true,
				width : 30
			}, {
				title : '发货人',
				field : 'goSendMan',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '电话',
				field : 'goSendPhone',
				align : 'center',
				sortable : true,
				width : 140
			}, {
				title : '地址',
				field : 'goSendAddress',
				align : 'center',
				sortable : true,
				width : 140
			}, {
				title : '收货人',
				field : 'goForMan',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				title : '电话',
				field : 'goForPhone',
				align : 'center',
				sortable : true,
				width : 140
			}, {
				title : '地址',
				field : 'goForAddress',
				align : 'center',
				sortable : true,
				width : 140
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
				width : 25
			}, {
				title : '保价费',
				field : 'goInsurancePay',
				align : 'center',
				sortable : true,
				width : 25
			}, {
				title : '代收货款',
				field : 'goReplacePay',
				align : 'center',
				sortable : true,
				width : 95
			}, {
				title : '货款扣',
				field : 'goDamagePay',
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
				title : '中转费',
				field : 'goTransitPay',
				align : 'center',
				sortable : true,
				width : 80
			}, {
				title : '备注',
				field : 'goRemark',
				align : 'center',
				sortable : true,
				width : 140
			} ] ],
			onLoadSuccess : function(data) {
				if(isSearchBtnClicked) {
					if(isAllNotNullStr) {
						console.log((data.rows[0]).goNum);
						isSearchBtnClicked = false;
					}
				}
			}
		});

		/* 显示所有 */
		$('#deliver_reload').click(function() {
			$("#deliver_datagrid").datagrid("load", {});
		});

		var url;
		/* 弹出添加窗口 */
		$('#deliver_add').click(function() {
			$('#deliver_edit_dlg').dialog('open').dialog('setTitle', '添加');
			url = 'goodsAdd';
		});
		
		/* 弹出编辑窗口 */
		$('#deliver_edit').click(function() {
			var row = $('#deliver_datagrid').datagrid('getSelected');
			if (row) {
				url = 'goodsUpda?goId=' + row.goId;
				$('#deliver_edit_dlg').dialog('open').dialog('setTitle', '编辑信息');
				$('#deliver_edit_fm').form('load', row);
			} else {
				$.messager.alert('提示', '请选择数据！');
			}
		});
		$('#deliver_edit_submit_button').click(function() {
			if (!$('#deliver_edit_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$.messager.confirm('确认', '确认保存吗？', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : url,
						data : $('#deliver_edit_fm').serialize(),
						success : function(data) {
							if (data.success) {
								$.messager.alert('提示', '保存成功！');
								$('#deliver_edit_dlg').dialog('close');
								$("#deliver_datagrid").datagrid("reload");
							} else {
								$.messager.alert('提示', '保存失败，请稍后再试！');
							}
						},
						error : function(request, error) {
							$.messager.alert('提示', '保存失败，请稍后再试！');
						}
					});
				} else {
					$('#deliver_edit_dlg').dialog('close');
				}
				$('#deliver_edit_fm').form('clear');
			});
		});

		/* 删除用户 */
		$('#deliver_delete').click(function() {
			var row = $('#deliver_datagrid').datagrid('getSelected');
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
								//var result = eval("(" + data + ")");
								if (data.success) {
									$.messager.alert('提示', '删除成功！');
									$("#deliver_datagrid").datagrid("reload");
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
		$('#deliver_search').click(function() {
			$('#deliver_search_dlg').dialog('open').dialog('setTitle', '搜索');
		});
		/* 搜索 */
		$('#deliver_search_button').click(function() {
			//验证是否都为空
			
			if (!$('#deliver_search_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			
			isSearchBtnClicked = true;
			isAllNotNullStr = ($('#deliver_carLicence').val() != '' && $('#deliver_logSendDate').val() != '');
			
			$('#deliver_datagrid').datagrid('load', {
			});
			$("#other").show();
			$('#deliver_search_dlg').dialog('close');
			$('#deliver_search_fm').form('clear');
		});

		/*弹出修改密码窗口*/
		var cgpwd_id;
		$('#deliver_password').click(
				function() {
					var row = $('#deliver_datagrid').datagrid('getSelected');
					if (row) {
						cgpwd_id = row.goId;
						$('#deliver_cgpwd_dlg').dialog('open').dialog('setTitle',
								'修改密码');
					} else {
						$.messager.alert('提示', '请选择数据！');
					}
				});
		
		/*打印*/
		$('#deliver_print').click(function() {
			var row = $('#deliver_datagrid').datagrid('getSelected');
			if (row) {
				$.ajax({
					type : 'POST',
					url : 'goodsPrint',
					data : {
						row : JSON.stringify(row)
					},
					success : function(data) {
						window.location.href = 'deliverPrint.jsp'
					},
					error : function(request, error) {
						$.messager.alert('提示', '预览失败，请稍后再试！');
					}
				});
			} else {
				$.messager.alert('提示', '请选择数据！');
			}
		});
		
		/*数据导入*/
		$('#deliver_input').click(function() {
			$('#deliver_input_dlg').dialog('open').dialog('setTitle', '数据导入');
			url='goodInput';
		});
	</script>

</div>
