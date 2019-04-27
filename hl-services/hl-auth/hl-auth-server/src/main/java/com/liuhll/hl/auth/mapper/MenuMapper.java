package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.Menu;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MenuMapper extends Mapper<Menu>, IdsMapper<Menu>, MySqlMapper<Menu> {
}