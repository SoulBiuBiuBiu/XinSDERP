<div id="Context_Bar" class="Bar_tools">
	<a class='easyui-linkbutton' href='JavaScript:void(0);' data-options="iconCls:'iconfont icon-viewlist',plain:true" onclick="UpdateTabs('order',ROOT+'App/Admin/Order/order.jsp','','iconfont icon-viewlist');"><span>管理</span></a>
	<a class='easyui-linkbutton' href='JavaScript:void(0);' id="main_save_btn" onclick="main_form_submit()" data-options="iconCls:'iconfont icon-save',plain:true"><span>保存</span></a>
</div>
<form id="Context_Submit_From" class="update_from easyui-tabs" action="/XinSDERP/dd/update" data-options="fit:true,border:false,tools:'#Context_Bar',toolPosition:'right'">
	<div title="订单录入" data-options="closable:false">
		<table>
			<tr>
			<input name="dd.user.id" id="Context_id" type="hidden" value="1">
				<th width="12%">订单编号 <span></span></th>
				<td width="38%"><input name="dd.ddbh" value="${dd.ddbh}" type="text" class="easyui-textbox" style="width:400px"  data-options="required:false"></td>
				<th width="12%">订货日期<span></span></th>
				<td width="38%"><input name="dd.ddrq" value="${dd.ddrq}" type="text" class="easyui-datebox" style="width:400px" data-options="required:true"></td>
			</tr>
			<tr>
				<th>订单交期 <span></span></th>
				<td><input name="dd.jq" value="${dd.jq}" type="text" class="easyui-datebox" style="width:300px" data-options="required:false"></td>
				<th>客户<span></span></th>
				<td> <input id="customerid" name="dd.gk.id" value="" type="hidden" />
					<input id="customername" name="dd.gk.dw" value="" type="text" class="easyui-textbox" readonly="readonly" style="width:300px">
					<a class="easyui-linkbutton" href="JavaScript:void(0);" data-options="iconCls:'iconfont icon-selected',plain:true" onclick="sysCustomerSelect();">选择</a>
					<a class="easyui-linkbutton" href="JavaScript:void(0);" data-options="iconCls:'iconfont icon-close',plain:true" onclick="sysCustomerClear();">清除</a>
				</td>
			</tr>
		</table>
	</div>
</form>
<div id="SysCustomerWin" class="easyui-dialog" title="选择客户" data-options="modal:true,closed:true,iconCls:'iconfont icon-account',
buttons:[{text:'确定',iconCls:'iconfont icon-selected',handler:function(){userSelect('SysCustomerWin','customer');}},
{text:'取消',iconCls:'iconfont icon-close',handler:function(){$('#SysCustomerWin').dialog('close');}}]" style="width:650px;height:400px;"></div>

<script type="text/javascript">
	function sysCustomerSelect() {
		var url = ROOT+'App/Admin/Selector/SysCustomerSelector.jsp?single=true';
		$('#SysCustomerWin').dialog({
			href: url
		});
		$('#SysCustomerWin').dialog('open');
	}

	function sysCustomerClear() {
		$('#customerid').val('');
		$('#customername').textbox('setValue', '');
	}
	//主表格提交
	function main_form_submit(form_name) {

		$.post($('#Context_Submit_From').attr("action"), $('#Context_Submit_From').serialize(), function(res) {
			if(!res.status) {
				$.messager.show({
					title: '错误提示',
					msg: res.info,
					timeout: 2000,
					showType: 'slide'
				});
			} else {
				$.messager.show({
					title: '成功提示',
					msg: res.info,
					timeout: 1000,
					showType: 'slide'
				});
				//			UpdateTabs(Model_name, res.url+'&cachedata='+new Date().getTime(), '', 'iconfont icon-viewlist');
				$('#Context_id').val(res.id); //赋值新增的信息的ID号
				//按钮控制代码
				$('#main_save_btn').linkbutton('disable');
				//				$('#text_add_btn').linkbutton('enable');
			}
		})

	}
</script>