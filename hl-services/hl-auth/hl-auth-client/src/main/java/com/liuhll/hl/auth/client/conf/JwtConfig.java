package com.liuhll.hl.auth.client.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

 @Data
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration:10000000}")
    private Long expiration;
    @Value("${auth.token-header:Authorization}")
    private String header;
}
