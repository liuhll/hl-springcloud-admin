package com.liuhll.hl.product.domain.models;

import lombok.Getter;

@Getter
public enum CommonStatus {

    Valid(1,"有效"),

    Invalid(0,"无效"),
    ;

    private Integer status;
    private String desc;

    CommonStatus(Integer status,String desc){
        this.status = status;
        this.desc = desc;
    }

}
