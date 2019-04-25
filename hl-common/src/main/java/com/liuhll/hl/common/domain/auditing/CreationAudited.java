package com.liuhll.hl.common.domain.auditing;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

@Data
public abstract class CreationAudited implements ICreationAudited {

    @Basic
    @Column(name = "CreateBy")
    protected Long createBy;

    @Basic
    @Column(name = "CreateTime")
    protected Date createTime = new Date();
}
