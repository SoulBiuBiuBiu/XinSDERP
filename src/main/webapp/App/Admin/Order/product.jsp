

<style>
    .Surveyheader tr
    {
        height: 30px;
    }
</style>
<div id="Survey_Bar" class="Bar_tools">
    <a class='easyui-linkbutton' href='JavaScript:void(0);' data-options="iconCls:'iconfont icon-viewlist',plain:true"
        onclick="UpdateTabs('Survey','Study/SurveyManage.aspx','','iconfont icon-viewlist');">
        <span>管理</span></a> <a class='easyui-linkbutton' href='JavaScript:void(0);' data-options="iconCls:'iconfont icon-save',plain:true"
            onclick="SurveyHdSubmit();"><span>保存</span></a>
</div>
<div id="SurveyItem_Bar" class="Bar_tools">
    <a class='easyui-linkbutton' href='JavaScript:void(0);' data-options="iconCls:'iconfont icon-add',plain:true"
        onclick="SurveyDtAdd();"><span>新增</span></a> <a class='easyui-linkbutton' href='JavaScript:void(0);'
            data-options="iconCls:'iconfont icon-edit',plain:true" onclick="SurveyDtEdit();">
            <span>编辑</span></a> <a class='easyui-linkbutton' href='JavaScript:void(0);' data-options="iconCls:'iconfont icon-delete',plain:true"
                onclick="SurveyDtDelete()"><span>删除</span></a>
</div>
<div id="SurveyEx_Bar" class="Bar_tools">
    <a class='easyui-linkbutton' href='JavaScript:void(0);' data-options="iconCls:'iconfont icon-add',plain:true"
        onclick="SurveyExAdd();"><span>新增</span></a> <a class='easyui-linkbutton' href='JavaScript:void(0);'
            data-options="iconCls:'iconfont icon-edit',plain:true" onclick="SurveyExEdit();">
            <span>编辑</span></a><a class='easyui-linkbutton' href='JavaScript:void(0);' data-options="iconCls:'iconfont icon-delete',plain:true"
                onclick="SurveyExDelete"><span>删除</span></a>
</div>
<div class="easyui-layout" style="width: 98%; height: 95%;">
    <div data-options="region:'north'" style="height: 93px; width: 100%; padding: 5px;">
        <form id="SurveyHd_Submit_Form" action="Study/SurveyHandler.ashx" class="update_from"
        data-options="fit:true,border:false,tools:'#Survey_Bar',toolPosition:'left'">
        <div>
            <table width="100%" class="Surveyheader">
                <tr>
                    <th>
                        调查名称 : <span></span>
                    </th>
                    <td>
                        <input name="title" value="" type="text" class="easyui-textbox" data-options="required:true"
                            style="width: 400px">
                    </td>
                    <th>
                        状态 : <span></span>
                    </th>
                    <td>
                        <select name="status" class="easyui-combobox" data-options="value:'1',multiple:false,required:false,editable:false">
                            <option value="1">有效</option>
                            <option value="0">结束</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>
                        时间安排 : <span></span>
                    </th>
                    <td>
                        <input class="easyui-datetimebox" name="start_time" data-options="required:true,showSeconds:false">
                        到
                        <input class="easyui-datetimebox" id="Text1" name="finish_time" data-options="required:true,showSeconds:false">
                    </td>
                    <th>
                        备注 : <span></span>
                    </th>
                    <td>
                        <input name="remark" value="" type="text" class="easyui-textbox" data-options="required:false,multiline:true"
                            style="width: 150px; height: 40px;">
                    </td>
                </tr>
            </table>
            <input type="hidden" name="id" id="hd_id" value="<%=hd_id %>" />
        </div>
        </form>
    </div>
    <div data-options="region:'center',title:'调查项'">
        <table id="SurveyItem_Data_List" height="100%">
        </table>
        <script type="text/javascript">
            $(function () {
                $("#SurveyItem_Data_List").datagrid({
                    url: "Study/SurveyHandler.ashx?action=listDt",
                    fit: true,
                    striped: true,
                    border: false,
                    pagination: true,
                    pageSize: 20,
                    queryParams: {
                    "S-HdId-N-EQ":<%=hd_id %>
                    },
                    pageList: [10, 20, 50],
                    pageNumber: 1,
                    sortName: 'id',
                    sortOrder: 'asc',
                    toolbar: '#SurveyItem_Bar',
                    singleSelect: true,
                    columns: [[
                            { field: 'id', title: 'ID', width: 100, sortable: false },
                            { field: 'title', title: '名称', width: 200, sortable: false },
                            { field: 'itemNum', title: '题型', width: 80, sortable: false,
                            formatter: function (value, row, index) {
            		if(!value)
                        return '多选';
            		else
            			return '单选';
                } }
                            
                            ]]
                });
            })
        </script>
    </div>
    <div data-options="region:'east',title:'调查项内容'" style="width: 400px;">
        <table id="SurveyEx_Data_List" height="100%">
        </table>
        <script type="text/javascript">
            $(function () {
                $("#SurveyEx_Data_List").datagrid({
                    url: "Study/SurveyHandler.ashx?action=listEx",
                    fit: true,
                    striped: true,
                    border: false,
                    pagination: true,
                    pageSize: 20,
                    queryParams: {
                        "S-DtId-N-EQ": 0
                    },
                    pageList: [10, 20, 50],
                    pageNumber: 1,
                    sortName: 'id',
                    sortOrder: 'asc',
                    toolbar: '#SurveyEx_Bar',
                    singleSelect: true,
                    columns: [[
                            { field: 'id', title: 'ID', width: 70, sortable: false },
                            { field: 'itemDesc', title: '选项名称', width: 300, sortable: false }
                            ]]
                });
            })
        </script>
    </div>
</div>
<div id="SurveyDtWin" class="easyui-dialog" title="调查子项详细" data-options="modal:true,closed:true,iconCls:'iconfont icon-map',buttons:[{text:'确定',iconCls:'iconfont icon-selected',handler:function(){SurveyDtSubmit();}},{text:'取消',iconCls:'iconfont icon-close',handler:function(){$('#SurveyDtWin').dialog('close');}}]"
    style="width: 450px; height: 200px;">
    <div id="SurveyExWin" class="easyui-dialog" title="调查项详细" data-options="modal:true,closed:true,iconCls:'iconfont icon-map',buttons:[{text:'确定',iconCls:'iconfont icon-selected',handler:function(){SurveyExSubmit();}},{text:'取消',iconCls:'iconfont icon-close',handler:function(){$('#SurveyExWin').dialog('close');}}]"
        style="width: 450px; height: 200px;">
    </div>
    <script>

        function SurveyDtAdd() {
        //debugger;
            var hd_id = $('#hd_id').val();
            if( hd_id == "0"){
            toast("错误提示","请先保存调查主题信息!");
            return ;
            }
             var url = 'Study/SurveyDtForm.aspx?type=add&hd_id='+hd_id;
             $('#SurveyDtWin').dialog({ href: url });
             $('#SurveyDtWin').dialog('open');
         }
         function SurveyDtEdit(){
         var row = $("#SurveyItem_Data_List").datagrid("getSelected");
         if(row == null){
             toast("错误提示","请选择相应的调查项!");
             return false;
           }
            var url = 'Study/SurveyDtForm.aspx?type=edit&id='+row.id;
             $('#SurveyDtWin').dialog({ href: url });
             $('#SurveyDtWin').dialog('open');
         }
         function SurveyDtDelete(){
         var row = $("#SurveyItem_Data_List").datagrid("getSelected");
         if(row == null){
             toast("错误提示","请选择相应的调查项!");
             return false;
           }
           $.post('Study/SurveyHandler.aspx?action=deleteDt&id='+row.id , {}, function (res) {
            res = eval("(" + res + ")");
            if (!res.status) {
                $.messager.show({ title: '错误提示', msg: res.info, timeout: 2000, showType: 'slide' });
            } else {
                $.messager.show({ title: '成功提示', msg: res.info, timeout: 1000, showType: 'slide' });
                $("#SurveyItem_Data_List").datagrid("reload");
            }
            });
         }
         function SurveyExAdd() {
           var row = $("#SurveyItem_Data_List").datagrid("getSelected");
           if(row == null){
             toast("错误提示","请选择相应的调查项!");
             return false;
           }
             var url = 'Study/SurveyExForm.aspx?type=add&dt_id='+row.id;
             $('#SurveyExWin').dialog({ href: url });
             $('#SurveyExWin').dialog('open');
        }

         function SurveyExEdit(){
         var row = $("#SurveyEx_Data_List").datagrid("getSelected");
         if(row == null){
             toast("错误提示","请选择相应的调查内容!");
             return false;
           }
            var url = 'Study/SurveyExForm.aspx?type=edit&id='+row.id;
             $('#SurveyExWin').dialog({ href: url });
             $('#SurveyExWin').dialog('open');
         }
          function SurveyExDelete(){
         var row = $("#SurveyEx_Data_List").datagrid("getSelected");
         if(row == null){
             toast("错误提示","请选择相应的调查项!");
             return false;
           }
           $.post('Study/SurveyHandler.aspx?action=deleteEx&id='+row.id , {}, function (res) {
            res = eval("(" + res + ")");
            if (!res.status) {
                $.messager.show({ title: '错误提示', msg: res.info, timeout: 2000, showType: 'slide' });
            } else {
                $.messager.show({ title: '成功提示', msg: res.info, timeout: 1000, showType: 'slide' });
                $("#SurveyEx_Data_List").datagrid("reload");
            }
            });
         }
         function SurveyHdSubmit(){
         var id = '<%=hd_id %>';
        if(id=="0"){
        var url = $('#SurveyHd_Submit_Form').attr("action")+"?action=add";
         //$('#hd_id').val("");
        }else{
        url = $('#SurveyHd_Submit_Form').attr("action")+"?action=edit";
        }        
          $.post(url , $('#SurveyHd_Submit_Form').serialize(), function (res) {
            res = eval("(" + res + ")");
            if (!res.status) {
                $.messager.show({ title: '错误提示', msg: res.info, timeout: 2000, showType: 'slide' });
            } else {
                $.messager.show({ title: '成功提示', msg: res.info, timeout: 1000, showType: 'slide' });
                $('#hd_id').val(res.id);
            }
        })
         }

         $('#SurveyItem_Data_List').datagrid({
	onClickRow: function(index,row){
     var queryParams = $('#SurveyEx_Data_List').datagrid('options').queryParams;
                    queryParams['S-DtId-N-EQ'] = row.id;
                    $('#SurveyEx_Data_List').datagrid('reload');
		
	}
});

         $(function () { 
         var h_id = <%=hd_id %>;
         if(h_id !=0){
         $.post("Study/SurveyHandler.ashx?action=getHd", { id: h_id }, function (data) {
            data=eval("("+data+")");
            //console.log(data);
            if (data.status) {
             $('#SurveyHd_Submit_Form').form('load', {
                    title: data.title,                 
                    start_time:data.start_time,
                    finish_time: data.finish_time,
                    status: data.status,
                    remark:data.remark
                     });
                 var queryParams = $('#SysUser_Data_List').datagrid('options').queryParams;
                    queryParams['S-areaid-S-LK'] = node.id;
                    $('#SysUser_Data_List').datagrid('reload');
             }
            });
         }
         });
    </script>
