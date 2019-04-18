package com.liuhll.hl.identity.client.runner;

import com.liuhll.hl.common.enums.ResultCode;
import com.liuhll.hl.common.vo.ResponseResult;
import com.liuhll.hl.identity.client.conf.ServiceAuthConfig;
import com.liuhll.hl.identity.client.conf.UserAuthConfig;
import com.liuhll.hl.identity.client.feign.ServiceAuthClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

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
        try {
            refreshJwtSecret();
        }catch (Exception e){
            log.error("初始化加载用户jwt Secret失败,1分钟后自动重试!",e);
        }

    }

    @Scheduled(cron = "0 0/1 * * * ?")
    private void refreshJwtSecret() {
        ResponseResult<String> jwtSecretResult = serviceAuthClient.getJwtSecret(serviceAuthConfig.getClientId(),serviceAuthConfig.getClientSecret());
        if (jwtSecretResult.getCode() == ResultCode.Ok){
            userAuthConfig.setJwtSecret(jwtSecretResult.getData());
        }

    }

}
