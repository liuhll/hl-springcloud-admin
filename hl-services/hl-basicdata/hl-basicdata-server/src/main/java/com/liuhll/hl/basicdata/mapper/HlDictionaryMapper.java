package com.liuhll.hl.basicdata.mapper;

import com.liuhll.hl.basicdata.domain.entity.HlDictionary;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface HlDictionaryMapper extends Mapper<HlDictionary>, IdsMapper<HlDictionary>, MySqlMapper<HlDictionary> {
}