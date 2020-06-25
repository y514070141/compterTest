$(function () {
    //加载视图
    $('#dg').datagrid({
        url:'/employeeList',
        columns:[[
            {field:'username',title:'用户名',width:100,align:'center'},
            {field:'password',title:'密码',width:100,align:'center'},
            {field:'tel',title:'电话',width:100,align:'center'},
            {field:'address',title:'地址',width:100,align:'center'},
            {field:'inputtime',title:'日期',width:100,align:'center'},
            {field:'email',title:'邮箱',width:100,align:'center'},
            {field:'department',title:'部门',width:100,align:'center',formatter: function(value,row,index){
                 // console.log(value);//对象字段值
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
        pagination:true,
        singleSelect:true,//datagrid只允许选中一行
        toolbar: '#tb'//加了四个按钮
    });
    $("#dialog").dialog({
        width:400,
        height:450,
        closed:true,
        buttons:[{
            text:'保存',
            handler:function(){
                var id=$("[name='id']").val();
                console.log(id);
                var url;
                if(id){
                    url='/updateEmployee';
                }else {
                    url='/saveEmployee';
                }
                $("#employeeForm").form("submit",{
                   url:url,
                    success:function (data) {
                       data=$.parseJSON(data);
                        if(data.success){
                            $.messager.alert("提示",data.msg,"info");
                            $("#dg").datagrid("reload");
                            $("#dialog").dialog("close");
                        }else {
                            $.messager.alert("提示",data.msg,"info");
                        }
                    }
                });
            }
        },{
            text:'关闭',
            handler:function(){
                $("#dialog").dialog("close");
            }
        }]
});
    //增加按钮
    $("#add").click(function () {
        /*设置标签*/
        $("#dialog").dialog("setTitle","添加员工");
        /*显示密码*/
        $("#password").show();
        /*清空对话框中的数据*/
        $("#employeeForm").form("clear");
        /*添加密码验证*/
        $("[name='password']").validatebox({required:true});
        /*打开对话框*/
        $("#dialog").dialog("open");
    });
    //编辑按钮
    $("#edit").click(function () {
        var row=$("#dg").datagrid("getSelected");
        if(!row){
            $.messager.alert("提示","请选择一行进行编辑","info");
            return;
        }
        //进行数据回显
        //取消密码验证 密码框隐藏
        $("[name='password']").validatebox({required:false});
        $("#password").hide();
        //回显部门
        row["department.id"]=row["department"].id;
        //回显角色
        // $.get("getRoleById?id="+rowData.id,function (data) {
        //     //接收的rid的集合 存到 下拉框
        //     $("#role").combobox("setValues",data);
        // });
        //加载数据
        $("#employeeForm").form("load",row);
        $("#dialog").dialog({closed:false,title:'编辑员工'});
    });
    //删除按钮
    $("#remove").click(function () {
        var row=$("#dg").datagrid("getSelected");
        if(!row){
            $.messager.alert("提示","请选择一行进行删除","info");
            return;
        }
        // console.log(row.id)
        $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
            if (r){
                //执行删除
                $.get(
                    "deleteEmployee"+row.id,function (data) {
                        if(data.success){
                            $.messager.alert("提示",data.msg,"info");
                            $("#dg").datagrid("reload");
                            $("#dialog").dialog("close");
                        }else {
                            $.messager.alert("提示",data.msg,"info");
                        }
                    }
                );
            }else {
                $.messager.alert("提示","用户取消了操作");
            }
        });

    });
    //刷新按钮
    $("#reload").click(function () {
        $("[name='keyword']").val('');
        $("#dg").datagrid("reload",{});
    });
    //查询  模糊 姓名 手机号
    $("#search").click(function () {
        //1.获取input标签值2.点击查询 增加一个条件
        // 3.分页一共三个参数 rows page keyword
        var keyword=$("[name='keyword']").val();

        alert(keyword)
    });
    /*部门选择 下拉列表*/
    $("#department").combobox({
        width: 150,
        panelHeight: 'auto',
        editable: false,
        url: 'departList',
        textField: 'name',
        valueField: 'id',
        onLoadSuccess: function () { /*数据加载完毕之后回调*/
            $("#department").each(function (i) {//i=0
                var span = $(this).siblings("span")[i];
                // console.log(span);
                var targetInput = $(span).find("input:first");
                if (targetInput) {
                    $(targetInput).attr("placeholder", $(this).attr("placeholder"));
                }
            });
        }
    });
});
