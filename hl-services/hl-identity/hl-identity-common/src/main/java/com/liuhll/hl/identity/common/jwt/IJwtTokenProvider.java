package com.liuhll.hl.identity.common.jwt;

import io.jsonwebtoken.Claims;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;


public interface IJwtTokenProvider extends Serializable {

    String generateToken(JwtUserClaims jwtCalims,Long expiration,String secret);

    Claims getClaimsFromToken(String token,String secret);

    JwtUserClaims getJwtUserClaims(String token,String secret);

    boolean validateToken(String token,String secret);

    String getUsernameFromToken(String token,String secret);

    String resolveToken(HttpServletRequest request,String header);
}
