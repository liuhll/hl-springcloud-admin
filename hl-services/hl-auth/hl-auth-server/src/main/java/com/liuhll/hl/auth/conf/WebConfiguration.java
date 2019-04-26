package com.liuhll.hl.auth.conf;

import com.liuhll.hl.auth.client.interceptor.UserAuthRestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;

@Configuration("authwebapiconfig")
@Primary
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    UserAuthRestInterceptor getUserAuthRestInterceptor() {
        return new UserAuthRestInterceptor();
    }

//    @Bean
//    ServiceAuthRestInterceptor getServiceAuthRestInterceptor(){
//        return new ServiceAuthRestInterceptor();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getUserAuthRestInterceptor()).
                addPathPatterns(getIncludePathPatterns());
//        registry.addInterceptor(getServiceAuthRestInterceptor()).
//                addPathPatterns(getIncludePathPatterns());
    }

    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "**/api/**",
                "/v1/**",
        };
        Collections.addAll(list, urls);
        return list;
    }

}
