package com.liuhll.hl.auth.client.conf;

import com.liuhll.hl.auth.client.interceptor.OnlyUserHlAuthRestIntterceptor;
import com.liuhll.hl.auth.client.interceptor.ServiceAuthRestInterceptor;
import com.liuhll.hl.auth.client.interceptor.UserAuthRestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;

@Configuration
public class HlServiceAuthWebConfig implements WebMvcConfigurer {


    @Autowired(required = false)
    private UserAuthRestInterceptor userAuthRestInterceptor;

    @Autowired(required = false)
    private ServiceAuthRestInterceptor serviceAuthRestInterceptor;

    @Autowired(required = false)
    private OnlyUserHlAuthRestIntterceptor onlyUserHlAuthRestIntterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (userAuthRestInterceptor != null){
            registry.addInterceptor(userAuthRestInterceptor).
                    addPathPatterns(getIncludePathPatterns());
        }
        if (serviceAuthRestInterceptor != null){
            registry.addInterceptor(serviceAuthRestInterceptor).
                    addPathPatterns(getIncludePathPatterns());
        }
        if (onlyUserHlAuthRestIntterceptor != null){
            registry.addInterceptor(onlyUserHlAuthRestIntterceptor).
                    addPathPatterns(getIncludePathPatterns());
        }



    }

    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/api/**",
                "/v*/**",
                "**/api/**",
        };
        Collections.addAll(list, urls);
        return list;
    }
}
