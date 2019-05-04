package com.liuhll.hl.basicdata.service;

import com.liuhll.hl.basicdata.domain.entity.Systemconf;
import com.liuhll.hl.basicdata.mapper.SystemconfMapper;
import com.liuhll.hl.basicdata.vo.sysconf.CreateSysConfInput;
import com.liuhll.hl.common.core.service.impl.BaseService;
import com.liuhll.hl.common.exception.BussinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SysConfService extends BaseService<SystemconfMapper, Systemconf> {

    public void saveSysConf(CreateSysConfInput input){
        Systemconf query = new Systemconf();
        query.setConfigName(input.getConfigName());
        Systemconf existConf = seleceOne(query);
        if (existConf != null){
            throw new BussinessException("已经存在".concat(input.getConfigName()).concat("的配置项"));
        }
        long count = selectAll().stream().count() + 1;
        Systemconf entity = new Systemconf();
        entity.setSeq(Integer.valueOf((int)(count + 1)));
        BeanUtils.copyProperties(input,entity);
        save(entity);
    }

}
