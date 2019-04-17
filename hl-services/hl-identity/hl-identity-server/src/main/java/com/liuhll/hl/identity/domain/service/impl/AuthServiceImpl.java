package com.liuhll.hl.identity.domain.service.impl;

import com.liuhll.hl.common.exception.UnAuthenticationException;
import com.liuhll.hl.identity.common.jwt.JwtUserClaims;
import com.liuhll.hl.identity.conf.JwtConfig;
import com.liuhll.hl.identity.domain.service.AuthService;
import com.liuhll.hl.identity.common.jwt.JwtTokenProvider;
import com.liuhll.hl.identity.jwt.JwtUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private JwtConfig jwtConfig;


    @Override
    public String login(String userName, String password) throws UnAuthenticationException {


        Authentication upToken = new UsernamePasswordAuthenticationToken(userName, password);
        Authentication authentication = null;
        try {
             authentication = authenticationManager.authenticate(upToken);
        }catch (AuthenticationException ex){
            throw new UnAuthenticationException("账号或密码错误");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(userName);
        JwtUserClaims jwtCalimsInfo = new JwtUserClaims();
        BeanUtils.copyProperties(jwtUser,jwtCalimsInfo);
        String token = jwtTokenProvider.generateToken(jwtCalimsInfo,jwtConfig.getExpiration(),jwtConfig.getSecret());
        return token;
    }
}
