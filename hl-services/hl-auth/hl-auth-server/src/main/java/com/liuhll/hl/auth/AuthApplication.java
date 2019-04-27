package com.liuhll.hl.auth;

import com.liuhll.hl.auth.client.EnableHlOnlyUserAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringCloudApplication
@ComponentScan(basePackages = {"com.liuhll.hl"})
@MapperScan("com.liuhll.hl.auth.mapper")
@EnableHlOnlyUserAuthClient
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class,args);
    }
}
