package com.itlike.service.impl;

import com.itlike.domain.Permission;
import com.itlike.domain.Role;
import com.itlike.mapper.RoleMapper;
import com.itlike.service.roleService;
import com.itlike.util.AjaxRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class roleServiveImpl implements roleService {
    @Autowired
    private RoleMapper roleMapper;

    //加载角色下拉框
    @Override
    public List<Role> getRoles() {
        return roleMapper.getRoles();
    }
    //保存角色权限
    @Override
    public void saveRole(Role role) {
            //1.保存角色
            roleMapper.insert(role);
            //2.保存角色关系
            for (Permission permission : role.getPermissions()) {
                roleMapper.saveRoleAndPermission(role.getRid(),permission.getPid());
            }
    }
    //查询角色 所有的 权限
    @Override
    public List<Permission> selectPermissionById(Long rid) {
        List<Permission> permissions = roleMapper.selectByRid(rid);
        return permissions;
    }

}
