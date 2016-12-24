<%@ page language="java" pageEncoding="UTF-8"%>
<div class="easyui-panel" data-options="fit:true,border:false">
	<div align="center"
		style="margin: 20px auto auto 20px; font-weight: bold; font-size: 20px;">

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
		style="padding: 0px 0px; width: 250px; height: 120px;"
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
				title : '时间',
				field : 'date',
				align : 'center',
				sortable : true,
				width : 150,
			},  {
				title : '总支出',
				field : 'sumExpent',
				align : 'center',
				sortable : true,
				width : 150,
			}, {
				title : '总收入',
				field : 'sumIncome',
				align : 'center',
				sortable : true,
				width : 100,
			}, {
				title : '结余',
				field : 'sumMoney',
				align : 'center',
				sortable : true,
				width : 100,
			} ] ]
		});
		
		/*把datebox改为只显示年月*/
		$(function() {      
		      $('#datetime1').datebox({    
		            onShowPanel : function() {// 显示日趋选择对象后再触发弹出月份层的事件，初始化时没有生成月份层    
		                span.trigger('click'); // 触发click事件弹出月份层    
		                if (!tds)    
		                    setTimeout(function() {// 延时触发获取月份对象，因为上面的事件触发和对象生成有时间间隔    
		                        tds = p.find('div.calendar-menu-month-inner td');    
		                        tds.click(function(e) {    
		                            e.stopPropagation(); // 禁止冒泡执行easyui给月份绑定的事件    
		                            var year = /\d{4}/.exec(span.html())[0]// 得到年份    
		                            , month = parseInt($(this).attr('abbr'), 10) + 1; // 月份    
		                            $('#datetime1').datebox('hidePanel')// 隐藏日期对象    
		                            .datebox('setValue', year + '-' + month); // 设置日期的值    
		                        });    
		                    }, 0);    
		            },    
		            parser : function(s) {// 配置parser，返回选择的日期    
		                if (!s)    
		                    return new Date();    
		                var arr = s.split('-');    
		                return new Date(parseInt(arr[0], 10), parseInt(arr[1], 10) - 1, 1);    
		            },    
		            formatter : function(d) {    
		                var month = d.getMonth();  
		                if(month<=10){  
		                    month = "0"+month;  
		                }  
		                if (d.getMonth() == 0) {    
		                    return d.getFullYear()-1 + '-' + 12;    
		                } else {    
		                    return d.getFullYear() + '-' + month;    
		                }    
		            }// 配置formatter，只返回年月    
		        });    
		        var p = $('#datetime1').datebox('panel'), // 日期选择对象    
		        tds = false, // 日期选择对象中月份    
		        span = p.find('span.calendar-text'); // 显示月份层的触发控件    
		        
		    });    

		/* 显示所有 */
		$('#money_reload').click(function() {
			$("#money_datagrid").datagrid("load", {});
		});

		/*弹出搜索窗口*/
		$('#money_search').click(
				function() {
					$('#money_search_dlg').dialog('open').dialog('setTitle',
							'搜索支出信息');
				});
		/* 搜索 */
		$('#money_search_button').click(function() {
			if (!$('#money_search_fm').form('validate')) {
				$.messager.alert('提示', '请正确填写信息！');
				return;
			}
			$('#money_datagrid').datagrid('load', {
				moneyDate : $('#datetime1').datebox('getValue'),
			});
			$('#money_search_dlg').dialog('close');
			$('#money_search_fm').form('clear');
		});
	</script>

</div>
