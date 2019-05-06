package com.liuhll.hl.auth.domain.models;

import lombok.Getter;

public enum UserLocked {
    Locked(1),
    UnLocked(0),
    ;

    @Getter
    private Integer value;
    UserLocked(Integer value){
        this.value = value;
    }
}
