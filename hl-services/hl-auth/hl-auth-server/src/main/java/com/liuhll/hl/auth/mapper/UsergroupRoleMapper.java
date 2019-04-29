package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.UsergroupRole;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface UsergroupRoleMapper extends Mapper<UsergroupRole>, IdsMapper<UsergroupRole>, MySqlMapper<UsergroupRole> {
}