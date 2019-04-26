package com.liuhll.hl.auth.vo;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeInput {
    private String username;

    private String chinesename;

    private String email;

    private String phone;

    private Integer gender;

    private Date birth;

    private String nativeplace;

    private String address;

    private String folk;

    private Integer politicalstatus;

    private String graduateinstitutions;

    private String education;

    private String major;

    private String resume;

    private String memo;

}
