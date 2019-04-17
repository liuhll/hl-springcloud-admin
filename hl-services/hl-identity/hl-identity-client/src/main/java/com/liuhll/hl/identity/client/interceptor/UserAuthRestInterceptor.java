package com.liuhll.hl.identity.client.interceptor;

import com.liuhll.hl.common.exception.UnAuthorizedException;
import com.liuhll.hl.common.runtime.session.HlContextSession;
import com.liuhll.hl.identity.client.annotation.IgnoreUserToken;
import com.liuhll.hl.identity.client.conf.UserAuthConfig;
import com.liuhll.hl.identity.common.jwt.JwtTokenProvider;
import com.liuhll.hl.identity.common.jwt.JwtUserClaims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserAuthConfig userAuthConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 配置该注解，说明不进行用户拦截
        IgnoreUserToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreUserToken.class);
        if (annotation == null) {
            annotation = handlerMethod.getMethodAnnotation(IgnoreUserToken.class);
        }
        if (annotation != null) {
            return super.preHandle(request, response, handler);
        }
        String token = jwtTokenProvider.resolveToken(request,userAuthConfig.getTokenHeader());
        if (StringUtils.isEmpty(token)) {
            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals(userAuthConfig.getTokenHeader())) {
                        token = cookie.getValue();
                    }
                }
            }
        }
        if (StringUtils.isEmpty(token)){
            throw new UnAuthorizedException("您还没有登录系统");
        }
        JwtUserClaims userClaims = jwtTokenProvider.getJwtUserClaims(token,userAuthConfig.getJwtSecret());
        HlContextSession.setUserId(userClaims.getUserid());
        HlContextSession.setUserName(userClaims.getUsername());
        return super.preHandle(request,response,handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HlContextSession.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
