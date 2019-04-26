package com.liuhll.hl.auth.client.interceptor;

import com.liuhll.hl.common.enums.ResultCode;
import com.liuhll.hl.common.exception.ClientForbiddenException;
import com.liuhll.hl.common.exception.HlException;
import com.liuhll.hl.common.security.ISecurityWhitelistHandler;
import com.liuhll.hl.auth.client.annotation.IgnoreClientToken;
import com.liuhll.hl.auth.client.conf.ServiceAuthConfig;
import com.liuhll.hl.auth.client.feign.ServiceAuthClient;
import com.liuhll.hl.common.vo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
public class ServiceAuthRestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private ServiceAuthClient serviceAuthClient;

    @Autowired
    private ISecurityWhitelistHandler securityWhitelistHandler;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        IgnoreClientToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreClientToken.class);
        if (annotation == null) {
            annotation = handlerMethod.getMethodAnnotation(IgnoreClientToken.class);
        }
        if (annotation != null) {
            return super.preHandle(request, response, handler);
        }
        String webapi = request.getRequestURI();
        if (securityWhitelistHandler.isPermitAuth(webapi)){
            return super.preHandle(request,response,handler);
        }

        List<String> allowedClients = serviceAuthClient.getAllowedClients(serviceAuthConfig.getClientId(),serviceAuthConfig.getClientSecret());
        if (allowedClients.stream().anyMatch(p->p.equals(serviceAuthConfig.getClientId()))){
            return super.preHandle(request,response,handler);
        }

        throw new ClientForbiddenException("Client is Forbidden!");
    }
}
