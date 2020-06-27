package com.itlike.web;

import com.itlike.domain.Permission;
import com.itlike.service.permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class permissionController {
    @Autowired
    private permissionService permissionService;

    @RequestMapping("/getPermissions")
    @ResponseBody
    public List<Permission> getPermissions(){
        return permissionService.getPermissions();
    }
}
