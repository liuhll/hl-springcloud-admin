package com.liuhll.hl.auth.service.impl;

import com.liuhll.hl.auth.domain.entity.Role;
import com.liuhll.hl.auth.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Override
    public Collection<Role> getRolesByUserId(Long userId) {
        List<Role>  roles = new ArrayList<>();
       // roles.add(new Role((new Integer(1).longValue()),"admin","管理员"));
        return roles;
    }
}
