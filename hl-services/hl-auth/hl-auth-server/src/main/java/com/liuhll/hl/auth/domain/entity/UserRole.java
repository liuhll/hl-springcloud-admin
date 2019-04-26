package com.liuhll.hl.auth.domain.entity;

import lombok.Data;

@Data
//@Entity
public class UserRole {

    private String userId;

    private String roleId;

    private Role role;
}
