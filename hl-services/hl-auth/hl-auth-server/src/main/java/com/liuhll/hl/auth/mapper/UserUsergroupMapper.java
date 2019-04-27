package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.UserUsergroup;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface UserUsergroupMapper extends Mapper<UserUsergroup>, IdsMapper<UserUsergroup>, MySqlMapper<UserUsergroup> {
}