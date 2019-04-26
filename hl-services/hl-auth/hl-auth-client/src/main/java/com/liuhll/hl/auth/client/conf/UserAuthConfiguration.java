package com.liuhll.hl.auth.client.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.liuhll.hl.auth.client"})
public class UserAuthConfiguration {
    @Bean
    UserAuthConfig getUserAuthConfig(){
        return new UserAuthConfig();
    }
}
