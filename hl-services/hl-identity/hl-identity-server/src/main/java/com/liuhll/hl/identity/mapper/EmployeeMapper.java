package com.liuhll.hl.identity.mapper;

import com.liuhll.hl.identity.domain.entity.Employee;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface EmployeeMapper extends Mapper<Employee>, IdsMapper<Employee>, MySqlMapper<Employee> {
}