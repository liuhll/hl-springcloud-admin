package com.liuhll.hl.identity.client.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class UserAuthConfig {
    @Value("${auth.user.token-header}")
    private String tokenHeader;
    @Value("${auth.user.jwt-secret}")
    private String jwtSecret;


}
