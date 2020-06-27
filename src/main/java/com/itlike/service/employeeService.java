package com.itlike.service;

import com.itlike.domain.Employee;
import com.itlike.domain.Role;
import com.itlike.util.AjaxRes;
import com.itlike.util.QueryVo;
import com.itlike.util.pageListRes;

import javax.management.Query;
import java.util.List;

public interface employeeService {
    //员工集合
    pageListRes employeeList(QueryVo queryVo);

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    //删除用户
    void deleteEmployee(Long id);


    //通过eid获取角色id
    List<Long> getRidByEid(Long id);
}
