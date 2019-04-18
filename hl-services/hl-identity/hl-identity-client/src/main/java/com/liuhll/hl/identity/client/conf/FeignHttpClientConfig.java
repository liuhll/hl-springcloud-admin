package com.liuhll.hl.identity.client.conf;

import com.liuhll.hl.identity.client.interceptor.HttpClientTokenInterceptor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AutoConfigureBefore(FeignAutoConfiguration.class)
@Configuration
public class FeignHttpClientConfig {

    @Bean
    public HttpClientTokenInterceptor httpClientTokenInterceptor() {
        return new HttpClientTokenInterceptor();
    }
}
