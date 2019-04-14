package com.liuhll.hl.identity.domain.service.impl;

import com.liuhll.hl.identity.domain.entity.Role;
import com.liuhll.hl.identity.domain.entity.UserInfo;
import com.liuhll.hl.identity.domain.service.RoleService;
import com.liuhll.hl.identity.domain.service.UserService;
import com.liuhll.hl.identity.jwt.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = userService.findUserInfoByName(userName);
        if (userInfo == null){
            throw new UsernameNotFoundException("未查到到用户用户");
        }
        Collection<Role> roles = roleService.getRolesByUserId(userInfo.getId());
        Collection<SimpleGrantedAuthority> authorities = roles.stream().map(role->new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toList());

        return new JwtUser(userInfo.getId().toString(),userInfo.getUserName(),userInfo.getPassword(),authorities);
    }
}
