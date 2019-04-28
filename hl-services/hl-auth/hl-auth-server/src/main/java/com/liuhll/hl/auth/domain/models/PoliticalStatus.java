package com.liuhll.hl.auth.domain.models;

import lombok.Getter;

public enum  PoliticalStatus {
    CPM(0, "中共党员"),

    LM(1, "团员"),

    PC(2, "群众"),

    DP(3, "民主党派"),

    NON(4, "无党派人士"),

    ;

    PoliticalStatus(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

    @Getter
    private Integer value;

    @Getter
    private String desc;
}
