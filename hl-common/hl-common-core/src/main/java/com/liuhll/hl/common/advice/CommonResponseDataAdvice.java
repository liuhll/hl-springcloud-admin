package com.liuhll.hl.common.advice;

import com.liuhll.hl.common.annotation.IgnoreResponseAdvice;
import com.liuhll.hl.common.enums.ResultCode;
import com.liuhll.hl.common.utils.ResponseResultUtil;
import com.liuhll.hl.common.vo.ResponseResult;
import com.liuhll.hl.common.exception.UnAuthenticationException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return  false;
        }
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (serverHttpRequest.getURI().getPath().contains("swagger") || serverHttpRequest.getURI().getPath().contains("api-docs")){
            return  o;
        }

        if (null == o){
            return ResponseResultUtil.success(o);
        }
        if (o instanceof HashMap){
            HashMap<String,Object> data = (HashMap<String, Object>) o;
            if (data.containsKey("status") && (Integer) data.get("status") == 403){
                return ResponseResultUtil.error(ResultCode.UnAuthentication,new UnAuthenticationException("您还没有登录系统"));
            }

        }
        if (o instanceof ResponseResult){
            return o;
        }
        return ResponseResultUtil.success(o);

    }

}
