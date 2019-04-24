package com.liuhll.hl.common.service.impl;

import com.liuhll.hl.common.service.IService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

@Data
public abstract class BaseService<M extends Mapper<T>, T>  implements IService<T> {

    @Autowired
    protected M mapper;

}
