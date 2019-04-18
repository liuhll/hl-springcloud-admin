package com.liuhll.hl.identity.client.interceptor;

import com.liuhll.hl.common.runtime.session.HlContextSession;
import com.liuhll.hl.identity.client.conf.UserAuthConfig;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.StringUtils;


public class HttpClientTokenInterceptor implements RequestInterceptor {

    @Autowired
    @Lazy
    private UserAuthConfig userAuthConfig;


    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (!StringUtils.isEmpty(HlContextSession.getAuthToken())){
            requestTemplate.header(userAuthConfig.getTokenHeader(),HlContextSession.getAuthToken());
        }
    }
}
