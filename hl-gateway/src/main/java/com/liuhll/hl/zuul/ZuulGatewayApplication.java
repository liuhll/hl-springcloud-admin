package com.liuhll.hl.zuul;

import com.liuhll.hl.auth.client.EnableHlAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy
@SpringCloudApplication
@ComponentScan(basePackages = {"com.liuhll.hl"})
@EnableHlAuthClient
public class ZuulGatewayApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }
}

