package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.MenuFunction;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MenuFunctionMapper extends Mapper<MenuFunction>, IdsMapper<MenuFunction>, MySqlMapper<MenuFunction> {
}