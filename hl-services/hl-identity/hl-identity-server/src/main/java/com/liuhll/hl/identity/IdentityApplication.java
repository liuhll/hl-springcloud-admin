package com.liuhll.hl.identity;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan(value = {"com.liuhll.hl"})

public class IdentityApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdentityApplication.class,args);
    }
}
