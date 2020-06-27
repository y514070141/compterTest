package com.itlike.service;

import com.itlike.domain.Permission;
import com.itlike.domain.Role;
import com.itlike.util.AjaxRes;

import java.util.List;

public interface roleService {
    //查询角色下拉框
    List<Role> getRoles();

    //保存角色
    void saveRole(Role role);

    //查询对象 所具有的 所有权限
    List<Permission> selectPermissionById(Long rid);
}
