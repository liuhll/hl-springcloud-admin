package com.liuhll.hl.filter;

import com.liuhll.hl.auth.client.conf.ServiceAuthConfig;
import com.liuhll.hl.common.HlGatewayConstants;
import com.liuhll.hl.common.auth.jwt.IJwtTokenProvider;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class AuthTokenFilter extends ZuulFilter {

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private IJwtTokenProvider jwtTokenProvider;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    @SneakyThrows
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String bearerToken = jwtTokenProvider.resolveToken(request, HlGatewayConstants.BearerTokenHeader);
        if (bearerToken != null){
            ctx.addZuulRequestHeader(serviceAuthConfig.getTokenHeader(),"Bearer " + bearerToken);
        }
        return null;
    }
}
