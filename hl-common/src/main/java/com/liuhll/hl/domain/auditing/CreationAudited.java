package com.liuhll.hl.domain.auditing;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

@Data
public abstract class CreationAudited {

    @Basic
    @Column(name = "create_by")
    private Long createBy;

    @Basic
    @Column(name = "create_time")
    private Date createTime = new Date();
}
