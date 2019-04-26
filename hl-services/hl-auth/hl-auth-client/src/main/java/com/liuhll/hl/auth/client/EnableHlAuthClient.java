package com.liuhll.hl.auth.client;

import com.liuhll.hl.auth.client.conf.ServiceAuthConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(ServiceAuthConfiguration.class)
@EnableFeignClients({"com.liuhll.hl.auth.client.feign"})
public @interface EnableHlAuthClient {
}
