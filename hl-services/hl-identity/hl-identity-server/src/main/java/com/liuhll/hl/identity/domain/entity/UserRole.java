package com.liuhll.hl.identity.domain.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
//@Entity
public class UserRole {

    private String userId;

    private String roleId;

    private Role role;
}
