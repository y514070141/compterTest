package com.itlike.web;

import com.itlike.domain.Permission;
import com.itlike.domain.Role;
import com.itlike.service.roleService;
import com.itlike.util.AjaxRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private roleService roleService;
    @RequestMapping("/role")
    public String employee(){
        return "role";
    }

//    加载datagird
    @RequestMapping("/getRoles")
    @ResponseBody
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

    //保存权限
    @RequestMapping("/saveRole")
    @ResponseBody
    public AjaxRes saveRole(Role role){
        AjaxRes ajaxRes=new AjaxRes();
        try{
            roleService.saveRole(role);
            ajaxRes.setMsg("保存成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("保存失败"+e.getMessage());
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    //通过rid查询她的权限   编辑权限回显
    @RequestMapping("/getPermissionByRid")
    @ResponseBody
    public List<Permission> getPermissionByRid(Role role){
        System.out.println("getPermissionByRid="+role);
        List<Permission> permissions = roleService.selectPermissionById(role.getRid());
        return permissions;
    }

    //删除权限
    @RequestMapping("/deleteRoleByRid{rid}")
    @ResponseBody
    public AjaxRes deleteRoleByRid(@PathVariable Long rid){
        AjaxRes ajaxRes=new AjaxRes();
        try{
            roleService.deleteRoleByRid(rid);
            ajaxRes.setMsg("删除成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("删除失败"+e.getMessage());
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }
}
