package com.liuhll.hl.auth.service.impl;

import com.liuhll.hl.auth.domain.entity.Role;
import com.liuhll.hl.auth.domain.entity.UserInfo;
import com.liuhll.hl.auth.jwt.JwtUser;
import com.liuhll.hl.auth.service.IRoleService;
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
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = userService.selectUserByName(userName);
        if (userInfo == null){
            throw new UsernameNotFoundException("未查到到用户用户");
        }
        Collection<Role> roles = roleService.getRolesByUserId(userInfo.getId());
        Collection<SimpleGrantedAuthority> authorities = roles.stream().map(role->new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toList());

        return new JwtUser(userInfo.getId().toString(),userInfo.getUsername(),userInfo.getPassword(),authorities);
    }
}
