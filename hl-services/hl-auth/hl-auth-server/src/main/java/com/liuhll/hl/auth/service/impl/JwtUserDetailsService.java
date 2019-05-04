package com.liuhll.hl.auth.service.impl;

import com.liuhll.hl.auth.domain.entity.Role;
import com.liuhll.hl.auth.domain.entity.UserInfo;
import com.liuhll.hl.auth.jwt.JwtUser;
import com.liuhll.hl.auth.service.IRoleService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoService userService;

    @Autowired
    private IRoleService roleService;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String account) {
        UserInfo userInfo = userService.selectUserByAccount(account);
        if (userInfo == null){
            throw new UsernameNotFoundException("不存在该用户,请检查账号");
        }
        Collection<Role> roles = roleService.getRolesByUserId(userInfo.getId());
        Collection<SimpleGrantedAuthority> authorities = roles.stream().map(role->new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toList());

        return new JwtUser(userInfo.getId().toString(),userInfo.getUserName(),userInfo.getPassword(),authorities);
    }
}
