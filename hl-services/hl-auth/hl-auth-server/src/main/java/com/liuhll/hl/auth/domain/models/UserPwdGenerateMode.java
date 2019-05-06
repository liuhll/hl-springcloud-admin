package com.liuhll.hl.auth.domain.models;

import lombok.Getter;

public enum  UserPwdGenerateMode {
    Random(0),
    Fixed(1),
    ;

    @Getter
    private Integer value;

    UserPwdGenerateMode(Integer value){
        this.value = value;
    }
}
