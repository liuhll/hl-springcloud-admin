package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.PermissionMenu;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface PermissionMenuMapper extends Mapper<PermissionMenu>, IdsMapper<PermissionMenu>, MySqlMapper<PermissionMenu> {
}