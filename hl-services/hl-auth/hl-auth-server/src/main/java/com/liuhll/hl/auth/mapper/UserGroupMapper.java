package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.UserGroup;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface UserGroupMapper extends Mapper<UserGroup>, IdsMapper<UserGroup>, MySqlMapper<UserGroup> {
}