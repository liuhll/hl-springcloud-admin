package com.liuhll.hl.basicdata;

import com.liuhll.hl.auth.client.EnableHlAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan({"com.liuhll.hl.*"})
@EnableHlAuthClient
public class BasicDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasicDataApplication.class);
    }
}
