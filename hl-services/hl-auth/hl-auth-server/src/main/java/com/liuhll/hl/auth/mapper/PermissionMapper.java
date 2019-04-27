package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.Permission;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface PermissionMapper extends Mapper<Permission>, IdsMapper<Permission>, MySqlMapper<Permission> {
}