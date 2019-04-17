package com.liuhll.hl.organization;

import com.liuhll.hl.identity.client.EnableHlIdentityClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan(value = {"com.liuhll.hl"})
@EnableHlIdentityClient
@EnableFeignClients({"com.liuhll.hl.identity.client.feign"})
public class OrganizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrganizationApplication.class,args);
    }
}
