package com.liuhll.hl.basicdata.mapper;

import com.liuhll.hl.basicdata.domain.entity.Systemconf;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SystemconfMapper extends Mapper<Systemconf>, IdsMapper<Systemconf>, MySqlMapper<Systemconf> {
}