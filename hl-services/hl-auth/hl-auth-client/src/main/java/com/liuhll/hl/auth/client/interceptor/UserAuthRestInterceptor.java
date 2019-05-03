package com.liuhll.hl.auth.client.interceptor;

import com.liuhll.hl.auth.client.conf.ServiceAuthConfig;
import com.liuhll.hl.auth.client.feign.ServiceAuthClient;
import com.liuhll.hl.common.auth.jwt.IJwtTokenProvider;
import com.liuhll.hl.common.auth.jwt.JwtUserClaims;
import com.liuhll.hl.common.auth.runtime.session.HlContextSession;
import com.liuhll.hl.common.enums.ResultCode;
import com.liuhll.hl.common.exception.HlException;
import com.liuhll.hl.common.exception.UnAuthorizedException;
import com.liuhll.hl.common.vo.ResponseResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserAuthRestInterceptor extends HlHandlerInterceptorAdapter {

    @Autowired
    private IJwtTokenProvider jwtTokenProvider;

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private ServiceAuthClient serviceAuthClient;

    @Override
    @SneakyThrows
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (super.preHlHandle(request,response,handler,IgnoreTokenType.User)){
            return super.preHandle(request,response,handler);
        }
        String token = jwtTokenProvider.resolveToken(request,serviceAuthConfig.getTokenHeader());
        if (StringUtils.isEmpty(token)) {
            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals(serviceAuthConfig.getTokenHeader())) {
                        token = cookie.getValue();
                    }
                }
            }
        }
        if (StringUtils.isEmpty(token)){
            throw new UnAuthorizedException("您还没有登录系统222");
        }
        ResponseResult<String> getJwtSecretResult = serviceAuthClient.getJwtSecret(serviceAuthConfig.getClientId(),serviceAuthConfig.getClientSecret());
        if (getJwtSecretResult.getCode() != ResultCode.Ok){
            throw new HlException(getJwtSecretResult.getMessage(),getJwtSecretResult.getCode());
        }

        JwtUserClaims userClaims = jwtTokenProvider.getJwtUserClaims(token,getJwtSecretResult.getData());
        HlContextSession.setUserId(userClaims.getUserid());
        HlContextSession.setUserName(userClaims.getUsername());
        HlContextSession.setAuthToken(token);
        return super.preHandle(request,response,handler);
    }



    @Override
    @SneakyThrows
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        HlContextSession.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
