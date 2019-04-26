package com.liuhll.hl.auth.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Long id;

    private String code;

    private String name;

}
