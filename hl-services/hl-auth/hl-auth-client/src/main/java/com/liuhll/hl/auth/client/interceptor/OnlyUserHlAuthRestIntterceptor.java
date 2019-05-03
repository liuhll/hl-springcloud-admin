package com.liuhll.hl.auth.client.interceptor;

import com.liuhll.hl.auth.client.conf.JwtConfig;
import com.liuhll.hl.common.auth.jwt.IJwtTokenProvider;
import com.liuhll.hl.common.auth.jwt.JwtUserClaims;
import com.liuhll.hl.common.auth.runtime.session.HlContextSession;
import com.liuhll.hl.common.exception.UnAuthorizedException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
public class OnlyUserHlAuthRestIntterceptor extends HlHandlerInterceptorAdapter {

    @Autowired
    private IJwtTokenProvider jwtTokenProvider;

    @Autowired
    private JwtConfig authJwtConfig;


    @Override
    @SneakyThrows
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (super.preHlHandle(request,response,handler,IgnoreTokenType.User)){
            return super.preHandle(request,response,handler);
        }

        String token = jwtTokenProvider.resolveToken(request,authJwtConfig.getHeader());
        if (StringUtils.isEmpty(token)) {
            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals(authJwtConfig.getHeader())) {
                        token = cookie.getValue();
                    }
                }
            }
        }

        if (StringUtils.isEmpty(token)){
            throw new UnAuthorizedException("您还没有登录系统111");
        }

        String secret = authJwtConfig.getSecret();
        JwtUserClaims userClaims = jwtTokenProvider.getJwtUserClaims(token,secret);
        HlContextSession.setUserId(userClaims.getUserid());
        HlContextSession.setUserName(userClaims.getUsername());
        HlContextSession.setAuthToken(token);
        return super.preHandle(request,response,handler);
    }



    @Override
    @SneakyThrows
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  {
        HlContextSession.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
