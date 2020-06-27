package com.itlike.mapper;

import com.itlike.domain.Permission;
import com.itlike.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    //删除角色表
    int deleteByPrimaryKey(Long rid);
    //删除角色关系表
    void deleteRoleAndPermissionByRid(Long rid);
    Role selectByPrimaryKey(Long rid);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
    //查询所有角色
    List<Role> getRoles();

    //保存角色
    int insert(Role record);
    //保存角色和权限关系
    void saveRoleAndPermission(@Param("rid") Long rid, @Param("pid") Long pid);

    //查询 角色对象 所有的权限
    List<Permission> selectByRid(Long rid);

}