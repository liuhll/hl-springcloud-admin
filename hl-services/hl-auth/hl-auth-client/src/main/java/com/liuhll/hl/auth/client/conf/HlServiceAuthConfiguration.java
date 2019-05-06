package com.liuhll.hl.auth.client.conf;

import com.liuhll.hl.auth.client.interceptor.ServiceAuthRestInterceptor;
import com.liuhll.hl.auth.client.interceptor.UserAuthRestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;

public class HlServiceAuthConfiguration {

    @Bean
    ServiceAuthConfig serviceAuthConfig(){
        return new ServiceAuthConfig();
    }

    @Bean
    @ConditionalOnBean({ServiceAuthConfig.class})
    UserAuthRestInterceptor userAuthRestInterceptor(){
        return new UserAuthRestInterceptor();
    }

    @Bean
    @ConditionalOnBean({ServiceAuthConfig.class})
    ServiceAuthRestInterceptor serviceAuthRestInterceptor(){
        return new ServiceAuthRestInterceptor();
    }
}
