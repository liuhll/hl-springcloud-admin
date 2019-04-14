package com.liuhll.hl.identity.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
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

    public Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw e;
        }
        return claims;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return true;
        } catch (ExpiredJwtException e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
        return username;
    }

    public String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader(header);
        if (bearerToken != null) {
            if (bearerToken.startsWith("Bearer ")){
                return bearerToken.substring(7);
            }
            return bearerToken;
        }
        return null;
    }
}
