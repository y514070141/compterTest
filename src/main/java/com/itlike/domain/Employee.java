package com.itlike.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Employee {
    private Long id;

    private String username;

    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputtime;

    private String email;
    private String tel;

    private String address;

    //保存部门
    private Department department;
    //保存角色
    private List<Role> roleList=new ArrayList<>();
}