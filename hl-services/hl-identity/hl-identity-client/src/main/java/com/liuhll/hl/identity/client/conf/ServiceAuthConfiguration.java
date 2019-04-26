package com.liuhll.hl.identity.client.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.liuhll.hl.identity.client"})
public class ServiceAuthConfiguration {

    @Bean
    ServiceAuthConfig getServiceAuthConfig(){
        return new ServiceAuthConfig();
    }
}
