package com.liuhll.hl.auth.client.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class ServiceAuthConfig {

    @Value("${auth.client.id:null}")
    private String clientId;

    @Value("${auth.client.secret}")
    private String clientSecret;


    @Value("${spring.application.name}")
    private String applicationName;

    public String getClientId() {
        return "null".equals(clientId)?applicationName:clientId;
    }
}
