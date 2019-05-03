package com.liuhll.hl.auth.service.impl;

import com.liuhll.hl.auth.domain.entity.ServiceComponent;
import com.liuhll.hl.auth.mapper.ServiceComponentMapper;
import com.liuhll.hl.common.core.service.impl.BaseService;
import com.liuhll.hl.common.exception.BussinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;


@Service
public class ServiceComponentService extends BaseService<ServiceComponentMapper, ServiceComponent> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public int saveServiceComponent(ServiceComponent component){
        Example example = Example.builder(ServiceComponent.class)
                .where(Sqls.custom().orEqualTo("serviceid",component.getServiceid()))
                .build();
        ServiceComponent exsitServiceComponent = mapper.selectOneByExample(example);
        if ( exsitServiceComponent != null ){
            throw new BussinessException("已经存在ServiceId".concat(component.getServiceid()).concat("的服务组件"));
        }
        component.setSecret(passwordEncoder.encode(component.getSecret()));
        return save(component);
    }
}
