package com.liuhll.hl.auth.vo.servicecomponentvo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class ServiceComponentInput {
    @NotBlank(message = "用户名不允许为空")
    @Pattern(regexp = "^([a-zA-Z0-9_-]|-){4,16}$",message = "服务组件名称不正确")
    private String serviceid;

    @NotBlank(message = "服务名不允许为空")
    private String name;

    @NotBlank(message = "服务组件密钥不允许为空")
    private String secret;

    private String memo;
}
