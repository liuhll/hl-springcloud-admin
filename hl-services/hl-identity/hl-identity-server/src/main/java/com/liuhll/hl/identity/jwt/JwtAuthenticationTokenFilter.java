package com.liuhll.hl.identity.jwt;

import com.alibaba.fastjson.JSON;
import com.liuhll.hl.common.enums.ResultCode;
import com.liuhll.hl.common.utils.ResponseResultUtil;
import com.liuhll.hl.common.vo.ResponseResult;
import com.liuhll.hl.identity.domain.service.impl.JwtUserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = jwtTokenUtil.resolveToken(request);
        try {
            if (jwtToken != null && StringUtils.isNotEmpty(jwtToken)) {
                String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                jwtTokenUtil.validateToken(jwtToken);//验证令牌

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
                    if (jwtTokenUtil.validateToken(jwtToken)) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            } else {
                String path = request.getRequestURI();
                if (!path.contains("swagger") && !path.contains("v2/api-docs") && !path.contains("login") && !path.contains("webjar")){
                    ResponseResult<String> result = ResponseResultUtil.error(ResultCode.UnAuthentication, "您还没有登录系统,请先登录系统");
                    writeResponseData(response, result);
                    return;
                }

            }
        } catch (ExpiredJwtException ex) {
            log.error(ex.getMessage(), ex);
            SecurityContextHolder.clearContext();
            ResponseResult<String> result = ResponseResultUtil.error(ResultCode.UnAuthentication, "登录超时,请重新登录");
            writeResponseData(response, result);
            return;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            SecurityContextHolder.clearContext();
            ResponseResult<String> result = ResponseResultUtil.error(ResultCode.UnAuthentication, ex.getMessage());
            writeResponseData(response, result);
            return;
        }

        filterChain.doFilter(request, response);
    }


    private void writeResponseData(HttpServletResponse response, ResponseResult<?> result) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }

}
