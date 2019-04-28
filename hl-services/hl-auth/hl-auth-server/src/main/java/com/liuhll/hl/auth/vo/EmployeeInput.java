package com.liuhll.hl.auth.vo;

import com.liuhll.hl.auth.domain.models.Gender;
import com.liuhll.hl.auth.domain.models.PoliticalStatus;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class EmployeeInput {

    @NotBlank(message = "用户名不允许为空")
//    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$",message = "用户名格式不正确")
    private String username;

    @NotBlank(message = "姓名不允许为空")
    private String chinesename;

    @NotBlank(message = "电子邮件不允许为空")
    @Email(message = "电子邮件格式不正确")
    private String email;

    @NotBlank(message = "用户名不允许为空")
//    @Pattern(regexp = "^(?:+?86)?1(?:3d{3}|5[^4D]d{2}|8d{3}|7(?:[01356789]d{2}|4(?:0d|1[0-2]|9d))|9[189]d{2}|6[567]d{2}|4(?:[14]0d{3}|[68]d{4}|[579]d{2}))d{6}$",message = "收集号码格式不正确")
    private String phone;

    @NotNull(message = "性别不允许为空")
    private Gender gender;

    private Date birth;

    private String nativeplace;

    private String address;

    private String folk;

    private PoliticalStatus politicalstatus;

    private String graduateinstitutions;

    private String education;

    private String major;

    private String resume;

    private String memo;

}
