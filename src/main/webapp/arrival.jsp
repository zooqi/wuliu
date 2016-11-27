<%@ page language="java" pageEncoding="UTF-8"%>

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
				title : '包装样式',
				field : 'goPack',
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
				$('#arvgs_fm').form('load', row);
				url = 'administrator/UpdateStudentUser?id=' + row.id;
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
				$('#arvgs_fm').form('clear');
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
							url : 'administrator/DeleteStudentUser',
							data : {
								id : row.id
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
