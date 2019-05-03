package com.liuhll.hl.auth.controller;

import com.liuhll.hl.auth.client.annotation.IgnoreUserToken;
import com.liuhll.hl.auth.client.conf.JwtConfig;
import com.liuhll.hl.auth.domain.entity.ServiceComponent;
import com.liuhll.hl.auth.service.IAuthClientService;
import com.liuhll.hl.auth.service.impl.ServiceComponentService;
import com.liuhll.hl.auth.vo.ServiceComponentInput;
import com.liuhll.hl.common.annotation.IgnoreResponseAdvice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/v1")
@RestController
public class ServiceController {

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private IAuthClientService authClientService;

    @Autowired
    private ServiceComponentService serviceComponentService;

    @IgnoreResponseAdvice
    @PostMapping("/service/allowedclients")
    @IgnoreUserToken
    public List<String> getAllowedClients(@RequestParam String clientId, @RequestParam String secret){
        authClientService.validate(clientId,secret);
        return Arrays.asList("hl-organization", "hl-product");
    }

    @PostMapping("/service/jwtsecret")
    @IgnoreUserToken
    public String getJwtSecret(@RequestParam String clientId, @RequestParam String secret ){
        authClientService.validate(clientId,secret);
        return jwtConfig.getSecret();
    }

    @PostMapping("api/sverice")
    public String addServiceComponent(@RequestBody ServiceComponentInput input){
        ServiceComponent serviceComponent = new ServiceComponent();
        BeanUtils.copyProperties(input,serviceComponent);
        serviceComponentService.saveServiceComponent(serviceComponent);
        return "新增服务组件成功";
    }
}
