package com.liuhll.hl.auth.client.interceptor;

import com.liuhll.hl.auth.client.conf.ServiceAuthConfig;
import com.liuhll.hl.common.runtime.session.HlContextSession;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.StringUtils;


public class HttpClientTokenInterceptor implements RequestInterceptor {

    @Autowired
    @Lazy
    private ServiceAuthConfig serviceAuthConfig;


    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (!StringUtils.isEmpty(HlContextSession.getAuthToken())){
            requestTemplate.header(serviceAuthConfig.getTokenHeader(),HlContextSession.getAuthToken());
        }
    }
}
