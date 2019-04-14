package com.liuhll.hl.identity.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "jwt")
@Component
@Data
@Slf4j
public class JwtTokenUtil implements Serializable {

    private String secret;

    private Long expiration;

    private String header;

    private String generateToken(Map<String,Object> claims){
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public String generateToken(JwtUser jwtUser){
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub",jwtUser.getUsername());
        claims.put("userid",jwtUser.getUserid());
        claims.put("created",new Date());
        return generateToken(claims);
    }
}
