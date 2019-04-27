package com.liuhll.hl.auth.mapper;

import com.liuhll.hl.auth.domain.entity.PermissionFile;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface PermissionFileMapper extends Mapper<PermissionFile>, IdsMapper<PermissionFile>, MySqlMapper<PermissionFile> {
}