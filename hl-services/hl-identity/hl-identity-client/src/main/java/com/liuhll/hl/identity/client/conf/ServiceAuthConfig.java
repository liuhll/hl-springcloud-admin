package com.liuhll.hl.identity.client.conf;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Data
public class ServiceAuthConfig {

    @Value("${auth.client.id:null}")
    private String clientId;

    @Value("${auth.client.secret}")
    private String clientSecret;

//    @Value("${auth.client.token-header}")
//    private String tokenHeader;

    @Value("${spring.application.name}")
    private String applicationName;

    public String getClientId() {
        return "null".equals(clientId)?applicationName:clientId;
    }
}
