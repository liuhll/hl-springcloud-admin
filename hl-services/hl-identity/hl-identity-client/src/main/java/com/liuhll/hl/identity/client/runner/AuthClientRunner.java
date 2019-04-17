package com.liuhll.hl.identity.client.runner;

import com.liuhll.hl.identity.client.conf.ServiceAuthConfig;
import com.liuhll.hl.identity.client.conf.UserAuthConfig;
import com.liuhll.hl.identity.client.feign.ServiceAuthClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AuthClientRunner implements CommandLineRunner {

    @Autowired
    private UserAuthConfig userAuthConfig;

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private ServiceAuthClient serviceAuthClient;

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化加载jwt Secret");
        refreshJwtSecret();
    }

    private void refreshJwtSecret() {
        String jwtSecret = serviceAuthClient.getJwtSecret(serviceAuthConfig.getClientId(),serviceAuthConfig.getClientSecret());
        userAuthConfig.setJwtSecret(jwtSecret);
    }
}
