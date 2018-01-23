<div  class="easyui-layout" style="width: 100%; height: 100%;">
    
    <div data-options="region:'center'" style="padding: 5px; background: #eee;">
       
                <div id="UserToolbar1" style="padding: 5px; height: auto">
                    <form id="TSysUserSearchForm">
                    <tr>
                        <td width="100" class="mt" bgcolor="#fff">
                            姓名：
                        </td>
                        <td>
                            <input name="s_username" class="easyui-textbox" panelheight="auto" style="width: 180px; height: 23px">
                        </td>
                    </tr>
                    <a href="javascript:;" onclick="TUserSearch();" class="easyui-linkbutton" iconcls="iconfont icon-search"> 搜索</a>
                    </form>
                </div>
                <table id="SysUser_Data_List">
                </table>
                <script type="text/javascript">
                    $(function () {
                        $("#SysUser_Data_List").datagrid({
                            url: "/XinSDERP/gk/list",
                            fit: true,
                            striped: true,
                            border: false,
                            rownumbers: true,
                           /*  queryParams: {
                               
                            }, */
                            checkOnSelect: true,
                            pagination: true,
                            pageSize: 20,
                            pageList: [10, 20, 50],
                            pageNumber: 1,
                            sortName: 'id',
                            sortOrder: 'desc',
                            toolbar: '#UserToolbar1',
                            singleSelect: true,
                            columns: [[
                                { field: 'id', title: 'ID', width: 60, sortable: true, checkbox: true },
                                { field: 'frdb', title: '法人代表', width: 100, sortable: true },
                                { field: 'sh', title: '税号', width: 100, sortable: true },
                                { field: 'dh', title: '电话', width: 80, sortable: true },
                                { field: 'frdb', title: '法人代表', width: 100, sortable: true },
                                { field: 'dw', title: '单位', width: 100, sortable: true },
                                { field: 'dz', title: '地址', width: 80, sortable: true }
		                    ]]
                        });
                    });

                    function userSelect(DialogWin,UserItem) {
                       var rows = $('#SysUser_Data_List').datagrid('getSelections');
                       /* debugger; */
                        if (rows.length == 0) {
                            $.messager.show({title:'错误提示',msg:'至少选择一个客户！',timeout:2000,showType:'slide'});
                        }else{
                            var id_arr = [],name_arr = [];
                            for (var i = 0; i < rows.length; i++) {
                            id_arr.push(rows[i].id);
                            name_arr.push(rows[i].dw);
                            }
                            ids=id_arr.join(',');
                             names = name_arr.join(',');
                            $('#'+UserItem+'id').val(ids);
                            $('#'+UserItem+'name').textbox('setValue',names);

                            $('#'+DialogWin).dialog('close');
                        }
                     }
                   

                    function TUserSearch() {
                        var queryParams = $('#SysUser_Data_List').datagrid('options').queryParams;
                        $.each($("#TSysUserSearchForm").form().serializeArray(), function (index) {
                            queryParams[this['name']] = this['value'];
                        });
                        $('#SysUser_Data_List').datagrid('reload');
                    }
                   
            </script>        
    </div>
</div>