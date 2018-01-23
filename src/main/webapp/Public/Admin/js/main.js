var ROOT='/XinSDERP/';
function MainMenuClick(m_id) {
	console.log("log");
	$('#LeftMenu').tree({
		url:'/XinSDERP/gmsauthrule/listMenuByPid?pid='+m_id
	});
	
	$('.top_nav a').removeClass("selected");
	$('#t_nav_'+m_id).addClass("selected");
}

function LeftMenuClick(node) {
//	debugger;
	if($('#LeftMenu').tree('isLeaf',node.target)){//判断是否是叶子节点
		//rule=node.attributes.rule;
		//var strs= new Array();
		/*strs=rule.split("/"); //字符分割 */
		var cname ='order'; //strs[1];
		var tit = node.text;
		var url =ROOT+ node.url;
		var icon = node.iconCls;
		if(icon==null){
			icon='iconfont icon-viewlist'
		}
		if (url) {
			UpdateTabs(cname, url, tit, icon);
		}
	}
}


function UpdateTabs(model_name, url, tit, icon) {
	if ($('#tabs_'+model_name).length>0) {
		index = $('#MainTabs').tabs('getTabIndex',$('#tabs_'+model_name));
		$('#MainTabs').tabs('select',index)
		Selected_tabs=$('#MainTabs').tabs('getSelected')
		options_s={}
		options_s.href=url
		options_s.bodyCls="tabs_box"
		if(tit!=''){
			options_s.title=tit
		}
		if(icon!=''){
			options_s.iconCls=icon
		}
		$('#MainTabs').tabs('update', {
			tab:Selected_tabs,
			options: options_s
		});
		Selected_tabs.panel('refresh');
	} else {
		options_s={}
		options_s.id='tabs_'+model_name
		options_s.title=tit
		options_s.href=url
		options_s.closable=true
		options_s.bodyCls="tabs_box"
		if(icon!=null){
			options_s.iconCls=icon
		}else{
			options_s.iconCls='iconfont icon-viewlist'
		}
		$('#MainTabs').tabs('add', options_s);
	}
}



function Datagrid_Ajax(url,Datagrid){
	$.post(url,{},function(res){
		if(!res.status){
			$.messager.show({title:'错误提示',msg:res.info,timeout:2000,showType:'slide'});
		}else{
			$('#'+Datagrid).datagrid('reload');
			$.messager.show({title:'成功提示',msg:res.info,timeout:1000,showType:'slide'});
		}
	})
}

function Datagrid_Ajax_Checkbox(url,Datagrid) {
	var rows = $('#'+Datagrid).datagrid('getSelections');
	if (rows.length == 0) {
		$.messager.show({title:'错误提示',msg:'至少选择一行记录！',timeout:2000,showType:'slide'});
	}else{
		var id_arr = [];
		for (var i = 0; i < rows.length; i++) {
			id_arr.push(rows[i].id);
		}
		ids=id_arr.join(',');
		$.post(url,{ids:ids},function(res){
			if(!res.status){
				$.messager.show({title:'错误提示',msg:res.info,timeout:2000,showType:'slide'});
			}else{
				$('#'+Datagrid).datagrid('reload');
				$.messager.show({title:'成功提示',msg:res.info,timeout:1000,showType:'slide'});
			}
		})
		
	}
}

//搜索
function Data_Search(Search_From,Datagrid_data){
	$('#'+Search_From).dialog({
		width:600,   
		height:350,  
		title : '搜索',
		modal:true,
		buttons : [{
				text : '搜索',
				iconCls : 'iconfont icon-search',
				handler : function () {
					var queryParams = $('#'+Datagrid_data).datagrid('options').queryParams;
					$.each($('#'+Search_From).serializeArray(), function() {
						queryParams[this['name']] = this['value'];
					});
					$('#'+Datagrid_data).datagrid('reload');
				}
			}]
	})
}

/* 提交表单 */
function From_Submit(Model_name){
	$.post($('#'+Model_name+'_Submit_From').attr("action"), $('#'+Model_name+'_Submit_From').serialize(), function(res){
		if(!res.status){
			$.messager.show({title:'错误提示',msg:res.info,timeout:2000,showType:'slide'});
		}else{
			$.messager.show({title:'成功提示',msg:res.info,timeout:1000,showType:'slide'});
			UpdateTabs(Model_name, res.url+'&cachedata='+new Date().getTime(), '', 'iconfont icon-viewlist');
		}
	})
}

function Data_Remove(Data_from_url,Datagrid_data){
	$.messager.confirm('确定操作', '您正在要删除所选的记录吗？', function (flag) {
		if (flag){
			$.post(Data_from_url,{},function(res){
				if(!res.status){
					$.messager.show({title:'错误提示',msg:res.info,timeout:2000,showType:'slide'});
				}else{
					$('#'+Datagrid_data).datagrid('reload');
					$.messager.show({title:'成功提示',msg:res.info,timeout:1000,showType:'slide'});
				}
			})
		}
	})
}
function Data_Check(Data_from_url,Datagrid_data){
	$.messager.confirm('确定操作', '您正在要审核所选的记录吗？', function (flag) {
		if (flag){
			$.post(Data_from_url,{},function(res){
				if(!res.status){
					$.messager.show({title:'错误提示',msg:res.info,timeout:2000,showType:'slide'});
				}else{
					$('#'+Datagrid_data).datagrid('reload');
					$.messager.show({title:'成功提示',msg:res.info,timeout:1000,showType:'slide'});
				}
			})
		}
	})
}
function Data_Remove2(Data_from_url,Datagrid_data){
	$.messager.confirm('确定操作', '您正在要删除所选的记录吗？', function (flag) {
		if (flag){
			$.post(Data_from_url,{},function(res){
				if(!res.status){
					$.messager.show({title:'错误提示',msg:res.info,timeout:2000,showType:'slide'});
				}else{
					$('#'+Datagrid_data).treegrid('reload');
					$.messager.show({title:'成功提示',msg:res.info,timeout:1000,showType:'slide'});
				}
			})
		}
	})
}
/* 刷新页面 */
function Data_Reload(Data_Box){
	$('#'+Data_Box).datagrid('reload');
}

/* 刷新页面 */
function Data_Reload2(Data_Box){
	$('#'+Data_Box).treegrid('reload');
}

