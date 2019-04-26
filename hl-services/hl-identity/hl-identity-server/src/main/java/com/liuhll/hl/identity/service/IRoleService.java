package com.liuhll.hl.identity.service;

import com.liuhll.hl.identity.domain.entity.Role;

import java.util.Collection;

public interface IRoleService {

    Collection<Role> getRolesByUserId(Long userId);
}
