$(function () {

    //datagird加载
    $("#role_dg").datagrid({
        url:"/getRoles",
        columns:[[
            {field:'rnum',title:'角色编号',width:100,align:'center'},
            {field:'rname',title:'角色名称',width:100,align:'center'}
        ]],
        fit:true,
        fitColumns:true,
        rownumbers:true,
        pagination:true,
        singleSelect:true,
        striped:true,
        pageList:[5,10,15,20],//初始化选择每页显示条数大小
        pageSize:5,//初始化页面数量 必须和集合一样
        toolbar:"#toolbar"
    });
    //弹窗
    $("#dialog").dialog({
        width:400,
        height:450,
        closed:true,
        buttons:[{
            text:'保存',
            handler:function(){
               alert("保存");
            }
        },{
            text:'关闭',
            handler:function(){
                $("#dialog").dialog("close");
            }
        }]
    });
    //添加
    $("#add").click(function () {
        $("#dialog").dialog("open");
    });
    //编辑

    //删除

});