package com.liuhll.hl.auth.client.interceptor;

import com.liuhll.hl.auth.client.conf.ServiceAuthConfig;
import com.liuhll.hl.auth.client.feign.ServiceAuthClient;
import com.liuhll.hl.common.exception.ClientForbiddenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
public class ServiceAuthRestInterceptor extends HlHandlerInterceptorAdapter {

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private ServiceAuthClient serviceAuthClient;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (super.preHlHandle(request,response,handler,IgnoreTokenType.Client)){
            return super.preHandle(request,response,handler);
        }

        List<String> allowedClients = serviceAuthClient.getAllowedClients(serviceAuthConfig.getClientId(),serviceAuthConfig.getClientSecret());
        if (allowedClients.stream().anyMatch(p->p.equals(serviceAuthConfig.getClientId()))){
            return super.preHandle(request,response,handler);
        }

        throw new ClientForbiddenException("Client is Forbidden!");
    }
}
