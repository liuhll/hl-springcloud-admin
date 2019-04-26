package com.liuhll.hl.identity.client.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.liuhll.hl.identity.client"})
public class UserAuthConfiguration {
    @Bean
    UserAuthConfig getUserAuthConfig(){
        return new UserAuthConfig();
    }
}
