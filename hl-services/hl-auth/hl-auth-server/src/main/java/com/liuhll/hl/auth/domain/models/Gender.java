package com.liuhll.hl.auth.domain.models;

import lombok.Getter;

public enum Gender {
    Male(0,"男"),

    Female(1,"女"),
    ;

    Gender(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

    @Getter
    private Integer value;

    @Getter
    private String desc;
}
