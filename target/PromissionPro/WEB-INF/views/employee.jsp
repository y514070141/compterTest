<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/static/common/common.jsp"%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/employee.js"></script>
</head>
<body>
<div id="tb">
    <a id="add" class="easyui-linkbutton" data-options="iconCls:'icon-add'">增加</a>
    <a id="edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
    <a id="remove" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
    <a id="reload" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">刷新</a>
    <input type="text" name="keyword">
    <button id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</button>
</div>
    <%--    <h1>员工主页</h1>--%>
    <table id="dg"></table>
<div id="dialog">
    <form id="employeeForm">
        <%--        编辑时 隐藏--%>
        <input type="hidden" name="id">
        <table align="center" style="border-spacing: 0px 10px">
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username" class="easyui-validatebox" data-options="required:true"></td>
            </tr>
            <tr id="password">
                <td>密码:</td>
                <td><input type="text" name="password" class="easyui-validatebox"></td>
            </tr>
            <tr>
                <td>手机:</td>
                <td><input type="text" name="tel" class="easyui-validatebox" ></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input type="text" name="email" class="easyui-validatebox" data-options="validType:'email'"></td>
            </tr>
            <tr>
                <td>地址:</td>
                <td><input type="text" name="address" class="easyui-validatebox" ></td>
            </tr>
            <tr>
                <td>入职日期:</td>
                <td><input type="text" name="inputtime" class="easyui-datebox"></td>
            </tr>
            <tr>
                <td>部门:</td>
                <td><input id="department" name="department.id" placeholder="请选择部门"/></td>
            </tr>
            <tr>
                <td>角色:</td>
                <td><input id="role" name="role.rid" placeholder="请选择部门"/></td>
            </tr>
        </table>

</div>

</body>
</html>
