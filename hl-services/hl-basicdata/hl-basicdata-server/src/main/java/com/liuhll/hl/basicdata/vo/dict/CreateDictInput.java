package com.liuhll.hl.basicdata.vo.dict;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class CreateDictInput {
    @NotBlank(message = "字典编码不允许为空")
    @Pattern(regexp = "^([a-zA-Z0-9_-]|-|_){4,16}$")
    private String code;

    @NotBlank(message = "字典名称不允许为空")
    private String name;

    @NotBlank(message = "字典值不允许为空")
    private String value;

    private Long parentid;

    private Integer seq = 1;

    private String typename;

    private Integer haschild = 0;
}
