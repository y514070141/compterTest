package com.itlike.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itlike.domain.Employee;
import com.itlike.mapper.EmployeeMapper;
import com.itlike.service.employeeService;
import com.itlike.util.AjaxRes;
import com.itlike.util.QueryVo;
import com.itlike.util.pageListRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class employeeServiceImpl implements employeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public pageListRes employeeList(QueryVo queryVo) {
        //分页查询    1.先设置页数，条数格式   2.在查询
        Page<Object> page = PageHelper.startPage(queryVo.getPage(), queryVo.getRows());
        List<Employee> employees = employeeMapper.selectAll(queryVo);

        pageListRes pageListRes = new pageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(employees);
        return pageListRes;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeMapper.saveEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Long> getRidByEid(Long id) {
        return employeeMapper.getRidByEid(id);
    }


}
