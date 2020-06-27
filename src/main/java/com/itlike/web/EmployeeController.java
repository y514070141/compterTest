package com.itlike.web;

import com.itlike.domain.Employee;
import com.itlike.domain.Role;
import com.itlike.service.employeeService;
import com.itlike.util.AjaxRes;
import com.itlike.util.QueryVo;
import com.itlike.util.pageListRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.Query;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private employeeService employeeService;

    @RequestMapping("/employeeList")
    @ResponseBody
    public pageListRes employeeList(QueryVo vo){
        return employeeService.employeeList(vo);
    }

    @RequestMapping("/employee")
    public String employee(){
        return "employee";
    }

//    保存
    @RequestMapping("/saveEmployee")
    @ResponseBody
    public AjaxRes saveEmployee(Employee employee){
        AjaxRes ajaxRes=new AjaxRes();
        try{
            employeeService.saveEmployee(employee);
            ajaxRes.setMsg("保存成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("保存失败"+e.getMessage());
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    //编辑
    @RequestMapping("/updateEmployee")
    @ResponseBody
    public AjaxRes updateEmployee(Employee employee){
        AjaxRes ajaxRes=new AjaxRes();
        try{
            employeeService.updateEmployee(employee);
            ajaxRes.setMsg("更新成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("更新失败"+e.getMessage());
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }
    //通过id删除用户   rest风格路径直接写变量
    @RequestMapping("/deleteEmployee{id}")
    @ResponseBody
    public AjaxRes deleteEmployee(@PathVariable Long id){
        AjaxRes ajaxRes=new AjaxRes();
        try{
            employeeService.deleteEmployee(id);
            ajaxRes.setMsg("删除成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("删除失败"+e.getMessage());
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    //通过编辑的id获取rid角色id
    @RequestMapping("/getRidByEid")
    @ResponseBody
    public List<Long> getRoleById(Long id){
        return employeeService.getRidByEid(id);
    }
}
