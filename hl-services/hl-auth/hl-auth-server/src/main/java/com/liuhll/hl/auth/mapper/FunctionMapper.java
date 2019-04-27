package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.Function;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface FunctionMapper extends Mapper<Function>, IdsMapper<Function>, MySqlMapper<Function> {
}