package com.liuhll.hl.identity.domain.entity;

import com.liuhll.hl.common.domain.Models.Status;
import com.liuhll.hl.common.domain.auditing.FullAuditedEntity;
import com.liuhll.hl.identity.domain.Models.PoliticalStatus;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "auth_employee")
public class Employee extends FullAuditedEntity {

    @Id
    private long id;

    private String userName;

    private String chineseName;

    private String email;

    private String phone;

    private Date birth;

    private String nativePlace;

    private String folk;

    private PoliticalStatus pliticalStatus;

    private String graduateInstitutions;

    private String education;

    private String major;

    private String resume;

    private String memo;

    private Status status;

}
