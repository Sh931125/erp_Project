package com.choongang.eprproject.employee.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface employeeDao {
    List<employeeDao> selectAll();
}
