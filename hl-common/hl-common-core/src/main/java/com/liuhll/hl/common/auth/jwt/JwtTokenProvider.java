package com.liuhll.hl.common.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Data
@Slf4j
public class JwtTokenProvider implements IJwtTokenProvider {



    private String generateToken(Map<String,Object> claims,Long expiration,String secret){
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public String generateToken(JwtUserClaims jwtCalims,Long expiration,String secret){
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub",jwtCalims.getUsername());
        claims.put("userid",jwtCalims.getUserid());
        claims.put("username",jwtCalims.getUsername());
        claims.put("created",new Date());
        return generateToken(claims,expiration,secret);
    }

    public Claims getClaimsFromToken(String token,String secret) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw e;
        }
        return claims;
    }

    public JwtUserClaims getJwtUserClaims(String token,String secret){
        Claims claims = getClaimsFromToken(token,secret);
        JwtUserClaims jwtUserClaims = new JwtUserClaims(claims.get("userid").toString(),claims.get("username").toString());
        return  jwtUserClaims;
    }

    public boolean validateToken(String token,String secret) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return true;
        } catch (ExpiredJwtException e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    public String getUsernameFromToken(String token,String secret) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token,secret);
            username = claims.getSubject();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
        return username;
    }

    public String resolveToken(HttpServletRequest request,String header){
        String bearerToken = request.getHeader(header);
        if (bearerToken == null){
            bearerToken = request.getHeader(header.toLowerCase());
        }
        if (bearerToken != null) {
            if (bearerToken.startsWith("Bearer ")){
                return bearerToken.substring(7);
            }
            return bearerToken;
        }
        return null;
    }
}
