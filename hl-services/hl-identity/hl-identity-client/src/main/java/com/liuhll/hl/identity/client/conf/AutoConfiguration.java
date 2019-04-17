package com.liuhll.hl.identity.client.conf;

import com.liuhll.hl.identity.client.conf.ServiceAuthConfig;
import com.liuhll.hl.identity.client.conf.UserAuthConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.liuhll.hl.identity.client"})
public class AutoConfiguration {

    @Bean
    UserAuthConfig getUserAuthConfig(){
        return new UserAuthConfig();
    }

    @Bean
    ServiceAuthConfig getServiceAuthConfig(){
        return new ServiceAuthConfig();
    }
}
