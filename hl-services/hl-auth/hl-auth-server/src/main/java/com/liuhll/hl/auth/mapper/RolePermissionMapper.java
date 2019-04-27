package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.RolePermission;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface RolePermissionMapper extends Mapper<RolePermission>, IdsMapper<RolePermission>, MySqlMapper<RolePermission> {
}