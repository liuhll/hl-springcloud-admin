package com.liuhll.hl.basicdata;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan({"com.liuhll.hl.*"})
public class BasicDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasicDataApplication.class);
    }
}
