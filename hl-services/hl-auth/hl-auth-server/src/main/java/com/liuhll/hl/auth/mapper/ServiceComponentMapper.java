package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.ServiceComponent;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface ServiceComponentMapper extends Mapper<ServiceComponent>, IdsMapper<ServiceComponent>, MySqlMapper<ServiceComponent> {
}