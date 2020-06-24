$(function () {
    $('#dg').datagrid({
        url:'/employeeList',
        columns:[[
            {field:'username',title:'用户名',width:100,align:'center'},
            {field:'password',title:'密码',width:100,align:'center'},
            {field:'inputtime',title:'日期',width:100,align:'center'},
            {field:'tel',title:'电话',width:100,align:'center'},
            {field:'address',title:'地址',width:100,align:'center'},
            {field:'department',title:'部门',width:100,align:'center',formatter: function(value,row,index){
                 console.log(value);//对象字段值
                //console.log(row);//一行数据
                // console.log(index);
                    if (value.name){
                        return value.name;
                    } else {
                        return value.id;
                    }
                }
            }
        ]],
        fit:true,
        fitColumns:true,
        rownumbers:true,
        pagination:true
    });
});
