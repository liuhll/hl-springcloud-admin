package com.liuhll.hl.common.domain.auditing;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

@Data
public abstract class FullAuditedEntity extends AuditedEntity implements IDeletionAudited {

    @Basic
    @Column(name = "CreateBy")
    protected Long createBy;

    @Basic
    @Column(name = "CreateTime")
    protected Date createTime = new Date();

    @Basic
    @Column(name = "UpdateBy")
    protected Long updateBy;

    @Basic
    @Column(name = "UpdateTime")
    protected Date updateTime = new Date();

    @Basic
    @Column(name = "IsDeleted")
    protected int isDeleted;

    @Basic
    @Column(name = "DeleteBy")
    protected long deleteBy;

    @Basic
    @Column(name = "DeleteTime")
    protected Date deleteTime;
}
