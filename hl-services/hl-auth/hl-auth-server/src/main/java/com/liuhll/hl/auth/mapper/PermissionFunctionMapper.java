package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.PermissionFunction;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface PermissionFunctionMapper extends Mapper<PermissionFunction>, IdsMapper<PermissionFunction>, MySqlMapper<PermissionFunction> {
}