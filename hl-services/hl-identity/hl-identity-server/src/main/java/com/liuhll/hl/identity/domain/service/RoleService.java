package com.liuhll.hl.identity.domain.service;

import com.liuhll.hl.identity.domain.entity.Role;

import java.util.Collection;

public interface RoleService {

    Collection<Role> getRolesByUserId(Long userId);
}
