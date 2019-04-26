package com.liuhll.hl.auth;

import com.liuhll.hl.auth.client.EnableUserAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringCloudApplication
@ComponentScan(basePackages = {"com.liuhll.hl"})
@MapperScan("com.liuhll.hl.auth.mapper")
@EnableUserAuthClient
public class IdentityApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdentityApplication.class,args);
    }
}
