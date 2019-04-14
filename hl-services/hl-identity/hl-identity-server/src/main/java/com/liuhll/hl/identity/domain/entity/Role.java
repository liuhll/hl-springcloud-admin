package com.liuhll.hl.identity.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
//@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Long id;

    private String code;

    private String name;

}
