package com.liuhll.hl.auth.service;

import com.liuhll.hl.auth.domain.entity.Role;

import java.util.Collection;

public interface IRoleService {

    Collection<Role> getRolesByUserId(Long userId);
}
