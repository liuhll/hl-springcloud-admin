package com.liuhll.hl.auth.vo;

import com.liuhll.hl.auth.domain.models.Gender;
import com.liuhll.hl.auth.domain.models.PoliticalStatus;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class EmployeeInput {

    @NotBlank(message = "用户名不允许为空")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$",message = "用户名格式不正确")
    private String userName;

    @NotBlank(message = "姓名不允许为空")
    private String chineseName;

    @NotBlank(message = "电子邮件不允许为空")
    @Email(message = "电子邮件格式不正确")
    private String email;

    @NotBlank(message = "用户名不允许为空")
    @Pattern(regexp = "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$",message = "手机号码格式不正确")
    private String phone;

    @NotNull(message = "性别不允许为空")
    private Gender gender;

    private Date birth;

    private String nativePlace;

    private String address;

    private String folk;

    private PoliticalStatus politicalStatus;

    private String graduateInstitutions;

    private String education;

    private String major;

    private String resume;

    private String memo;

}
