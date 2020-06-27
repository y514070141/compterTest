package com.itlike.mapper;

import com.itlike.domain.Employee;
import com.itlike.util.QueryVo;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    void saveEmployee(Employee employee);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll(QueryVo queryVo);

    int updateByPrimaryKey(Employee record);

    //通过eid获取角色id
    List<Long> getRidByEid(Long id);
}