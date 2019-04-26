package com.liuhll.hl.auth.service.impl;

import com.liuhll.hl.auth.service.IAuthClientService;
import com.liuhll.hl.common.exception.ClientAuthException;
import com.liuhll.hl.common.exception.ClientForbiddenException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthClientService implements IAuthClientService {
    private Map<String,String> clients = new HashMap<>();

    public AuthClientService(){
        // :todo 从数据库中查询
        clients.put("hl-organization","123456");
        clients.put("hl-product","123456");
    }


    @Override
    public void validate(String clientId, String clientSecret) {
        if (!clients.containsKey(clientId)){
            throw new ClientAuthException("不存在AppId为" + clientId + "的应用");
        }
        String appSecret = clients.get(clientId);
        if (!appSecret.equals(clientSecret)){
            throw new ClientForbiddenException("应用密钥错误");
        }
    }
}
