package com.itlike.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class RoleController {
    @RequestMapping("/role")
    public String employee(){
        return "role";
    }
}
