package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.UserRole;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface UserRoleMapper extends Mapper<UserRole>, IdsMapper<UserRole>, MySqlMapper<UserRole> {
}