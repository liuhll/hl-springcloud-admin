package com.liuhll.hl.auth.service.impl;

import com.liuhll.hl.auth.domain.entity.ServiceComponent;
import com.liuhll.hl.auth.mapper.ServiceComponentMapper;
import com.liuhll.hl.auth.service.IAuthClientService;
import com.liuhll.hl.common.core.domain.models.Status;
import com.liuhll.hl.common.core.service.impl.BaseService;
import com.liuhll.hl.common.exception.BussinessException;
import com.liuhll.hl.common.exception.ClientAuthException;
import com.liuhll.hl.common.exception.ClientForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceComponentService extends BaseService<ServiceComponentMapper, ServiceComponent> implements IAuthClientService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void validate(String clientId, String clientSecret) {
        ServiceComponent selectServiceComponent = getServiceComponent(clientId);

        if (selectServiceComponent == null){
            throw new ClientAuthException("不存在AppId为" + clientId + "的应用");
        }
        if (selectServiceComponent.getStatus() == Status.Invalid){
            throw new ClientAuthException("AppId为" + clientId + "的应用被冻结");
        }

        if (!passwordEncoder.matches(clientSecret,selectServiceComponent.getSecret())){
            throw new ClientForbiddenException("应用密钥错误");
        }
    }

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

    public ServiceComponent getServiceComponent(String serviceid){
        ServiceComponent query = new ServiceComponent();
//        query.setStatus(Status.Valid);
        query.setServiceid(serviceid);
        return mapper.selectOne(query);
    }

    public List<ServiceComponent> getAllServiceComponents(){
        ServiceComponent query = new ServiceComponent();
//        query.setStatus(Status.Valid);
        return mapper.select(query);
    }

    public List<ServiceComponent> getAllValidServiceComponents(){
        ServiceComponent query = new ServiceComponent();
        query.setStatus(Status.Valid);
        return mapper.select(query);
    }
}
