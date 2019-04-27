package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.OrgRole;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface OrgRoleMapper extends Mapper<OrgRole>, IdsMapper<OrgRole>, MySqlMapper<OrgRole> {
}