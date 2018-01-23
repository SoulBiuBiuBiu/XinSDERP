
<div class="easyui-layout" fit="true">
	<div region="north" border="true" style="height:65px;">
		<form id="Context_Search_From" class="search_from">
			<table>
				<tr>
					<th style="width: 60px" style="text-align:left;">订单编号:</th>
					<td><input name="dd.ddbh" type="text" class="easyui-textbox"></td>
					<th style="width: 60px">客户单位</th>
					<td><input name="dd.gk.dw" type="text" class="easyui-textbox"></td>
					<th style="width: 60px">日期:</th>
					<td><input name="minTime" type="text" class="easyui-datetimebox" style="width: 120px;"> -
						<input name="maxTime" type="text" class="easyui-datetimebox" style="width: 120px;"></td>
					<td>
						<a class='easyui-linkbutton' href='JavaScript:void(0);' data-options="iconCls:'iconfont icon-search'" onclick="Search('Context_Search_From','Context_Data_List');"><span>搜索</span></a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="Context_Bar" class="Bar_tools">
		<a class='easyui-linkbutton' href='JavaScript:void(0);' data-options="iconCls:'iconfont icon-add',plain:true" onclick="UpdateTabs('order','/XinSDERP/App/Admin/Order/add.jsp','','iconfont icon-add');"><span>新增</span></a>
		<a class='easyui-linkbutton' href='JavaScript:void(0);' data-options="iconCls:'iconfont icon-refresh',plain:true" onclick="Data_Reload('Context_Data_List');"><span>刷新</span></a>
	</div>
	<div region="center" border="false">
		<table id="Context_Data_List"></table>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$("#Context_Data_List").datagrid({
			url: "/XinSDERP/dd/list",
			fit: true,
			striped: true,
			border: false,
			pagination: true,
			height: 400,
			pageSize: 20,
			pageList: [10, 20, 50],
			pageNumber: 1,
			sortName: 'ddrq',
			sortOrder: 'desc',
			toolbar: '#Context_Bar',
			singleSelect: true,
			columns: [
				[{
						field: 'ddbh',
						title: '订单编号',
						width: 60,
						sortable: true
					},
					{
						field: 'ddrq',
						title: '订货日期',
						width: 340,
						sortable: true
					},
					{
						field: 'jq',
						title: '交货日期',
						width: 340,
						sortable: true
					},
					{
						field: 'gk',
						title: '客户单位',
						width: 100, 
						sortable: true,
						formatter: function(value,row){
						
						  if(value!= undefined){
						  return value.dw;
						  }else{
						  return '';}
						}
					},
					{
						field: 'je',
						title: '合同金额',
						width: 200,
						sortable: true
					},
					{
						field: 'operate',
						title: '操作',
						width: 100
					}
				]
			]
		});
	});

	//æç´¢
	function Search(Search_From, Datagrid_data) {
		var queryParams = $('#' + Datagrid_data).datagrid('options').queryParams;
		$.each($('#' + Search_From).serializeArray(), function() {
			queryParams[this['name']] = this['value'];
		});
		$('#' + Datagrid_data).datagrid('load');
	}
</script>