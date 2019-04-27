package com.liuhll.hl.auth.client.interceptor;

import com.liuhll.hl.auth.client.annotation.IgnoreClientToken;
import com.liuhll.hl.auth.client.annotation.IgnoreUserToken;
import com.liuhll.hl.auth.client.security.ISecurityWhitelistHandler;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HlHandlerInterceptorAdapter  extends HandlerInterceptorAdapter {

    @Autowired
    protected ISecurityWhitelistHandler securityWhitelistHandler;

    @SneakyThrows
    protected boolean preHlHandle(HttpServletRequest request, HttpServletResponse response, Object handler, IgnoreTokenType ignoreTokenType) {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 配置该注解，说明不进行用户拦截

        switch (ignoreTokenType){
            case User:
                IgnoreUserToken ignoreUserTokenAunotation = handlerMethod.getBeanType().getAnnotation(IgnoreUserToken.class);
                if (ignoreUserTokenAunotation == null) {
                    ignoreUserTokenAunotation = handlerMethod.getMethodAnnotation(IgnoreUserToken.class);
                }
                if (ignoreUserTokenAunotation != null) {
                    return true;
                }
                break;

            case Client:
                IgnoreClientToken ignoreClientTokenAunotation = handlerMethod.getBeanType().getAnnotation(IgnoreClientToken.class);
                if (ignoreClientTokenAunotation == null) {
                    ignoreClientTokenAunotation = handlerMethod.getMethodAnnotation(IgnoreClientToken.class);
                }
                if (ignoreClientTokenAunotation != null) {
                    return true;
                }
                break;
        }
        String webapi = request.getRequestURI();
        if (securityWhitelistHandler.isPermitAuth(webapi)){
            return super.preHandle(request,response,handler);
        }
        return false;
    }
}
