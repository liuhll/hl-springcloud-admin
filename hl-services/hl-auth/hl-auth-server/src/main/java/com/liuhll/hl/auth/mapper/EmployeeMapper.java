package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.Employee;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface EmployeeMapper extends Mapper<Employee>, IdsMapper<Employee>, MySqlMapper<Employee> {
}
