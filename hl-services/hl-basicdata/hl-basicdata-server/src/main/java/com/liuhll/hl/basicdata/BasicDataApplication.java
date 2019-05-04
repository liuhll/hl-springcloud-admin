package com.liuhll.hl.basicdata;

import com.liuhll.hl.auth.client.EnableHlAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringCloudApplication
@ComponentScan({"com.liuhll.hl.*"})
@MapperScan("com.liuhll.hl.basicdata.mapper")
@EnableHlAuthClient
public class BasicDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasicDataApplication.class);
    }
}
