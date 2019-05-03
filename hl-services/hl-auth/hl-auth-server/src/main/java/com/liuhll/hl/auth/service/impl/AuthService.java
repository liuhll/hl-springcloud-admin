package com.liuhll.hl.auth.service.impl;

import com.liuhll.hl.auth.client.conf.JwtConfig;
import com.liuhll.hl.common.auth.jwt.IJwtTokenProvider;
import com.liuhll.hl.common.auth.jwt.JwtUserClaims;
import com.liuhll.hl.auth.jwt.JwtUser;
import com.liuhll.hl.auth.service.IAuthService;
import com.liuhll.hl.common.exception.UnAuthenticationException;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IJwtTokenProvider jwtTokenProvider;

    @Autowired
    private JwtConfig authJwtConfig;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @SneakyThrows
    public String login(String userName, String password) {

        Authentication upToken = new UsernamePasswordAuthenticationToken(userName, password);
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(upToken);
        }catch (UsernameNotFoundException ex){
            throw new UnAuthenticationException("不存在该用户名");
        }catch (BadCredentialsException ex){
            throw new UnAuthenticationException("密码错误,请检查密码");
        }catch (AuthenticationException ex){
            throw new UnAuthenticationException(ex.getMessage());
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(userName);
        JwtUserClaims jwtCalimsInfo = new JwtUserClaims();
        BeanUtils.copyProperties(jwtUser,jwtCalimsInfo);
        String token = jwtTokenProvider.generateToken(jwtCalimsInfo,authJwtConfig.getExpiration(),authJwtConfig.getSecret());
        return token;
    }
}
