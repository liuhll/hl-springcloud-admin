package com.liuhll.hl.organization;

import com.liuhll.hl.identity.client.EnableHlAuthClient;
import com.liuhll.hl.identity.client.EnableUserAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringCloudApplication
@ComponentScan(value = {"com.liuhll.hl"})
@EnableHlAuthClient
@EnableFeignClients({"com.liuhll.hl.identity.client.feign"})
public class OrganizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrganizationApplication.class,args);
    }
}
