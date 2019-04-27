package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.rUsergroupRole;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface rUsergroupRoleMapper extends Mapper<rUsergroupRole>, IdsMapper<rUsergroupRole>, MySqlMapper<rUsergroupRole> {
}