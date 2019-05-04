package com.liuhll.hl.basicdata.vo.sysconf;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class CreateSysConfInput {

    @NotBlank(message = "配置名称不允许为空")
    @Pattern(regexp = "^([a-zA-Z0-9_-]|-|_){4,16}$",message = "配置名称命名不正确")
    private String configName;

    @NotBlank(message = "配置值不允许为空")
    private String configValue;

    private String memo;

}
