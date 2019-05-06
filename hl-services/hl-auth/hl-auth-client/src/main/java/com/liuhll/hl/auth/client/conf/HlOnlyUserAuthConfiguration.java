package com.liuhll.hl.auth.client.conf;

import com.liuhll.hl.auth.client.interceptor.OnlyUserHlAuthRestIntterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;

//@Configuration
public class HlOnlyUserAuthConfiguration {

    @Bean
    JwtConfig jwtConfig(){
        return new JwtConfig();
    }

    @Bean
    ServiceAuthConfig serviceAuthConfig(){
        return new ServiceAuthConfig();
    }

    @Bean
    @ConditionalOnBean({JwtConfig.class})
    OnlyUserHlAuthRestIntterceptor authClientUserAuthRestIntterceptor(){
        return new OnlyUserHlAuthRestIntterceptor();
    }

}
