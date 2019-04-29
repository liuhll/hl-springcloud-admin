package com.liuhll.hl.common.domain.auditing;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

@Data
public abstract class AuditedEntity extends CreationAudited implements IModificationAudited {
    @Basic
    @Column(name = "CreateBy")
    protected Long createBy;

    @Basic
    @Column(name = "CreateTime")
    protected Date createTime;

    @Basic
    @Column(name = "UpdateBy")
    protected Long updateBy;

    @Basic
    @Column(name = "UpdateTime")
    protected Date updateTime;

}
