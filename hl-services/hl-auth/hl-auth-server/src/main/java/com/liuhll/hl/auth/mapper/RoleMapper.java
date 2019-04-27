package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.Role;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface RoleMapper extends Mapper<Role>, IdsMapper<Role>, MySqlMapper<Role> {
}