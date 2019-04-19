package com.liuhll.hl.identity.conf;


import com.liuhll.hl.common.conf.SecurityWhitelistConfig;
import com.liuhll.hl.identity.domain.service.impl.JwtUserDetailsServiceImpl;
import com.liuhll.hl.identity.jwt.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected SecurityWhitelistConfig whitelistConfig;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder())
                .and()
                .inMemoryAuthentication()
                .withUser("liuhl")
                .password(passwordEncoder().encode("liuhl"))
                .roles("admin")

        ;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/identity").permitAll()
                .antMatchers("/**/swagger*", "/**/swagger*/**", "/**/webjars/**", "/**/v2/api-docs", "/**/csrf").permitAll()
                .antMatchers(whitelistConfig.getWhitelist().toArray(new String[whitelistConfig.getWhitelist().size()])).permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable()
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
        ;
 //       http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Autowired
    private JwtUserDetailsServiceImpl userDetailsService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
}
