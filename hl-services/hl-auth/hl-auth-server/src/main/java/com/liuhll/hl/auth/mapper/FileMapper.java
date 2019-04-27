package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.File;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface FileMapper extends Mapper<File>, IdsMapper<File>, MySqlMapper<File> {
}