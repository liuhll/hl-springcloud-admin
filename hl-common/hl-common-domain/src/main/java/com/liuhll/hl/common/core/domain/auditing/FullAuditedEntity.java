package com.liuhll.hl.common.core.domain.auditing;

import lombok.Data;
import tk.mybatis.mapper.annotation.LogicDelete;

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
    protected Date createTime;

    @Basic
    @Column(name = "UpdateBy")
    protected Long updateBy;

    @Basic
    @Column(name = "UpdateTime")
    protected Date updateTime;

    @Basic
    @LogicDelete
    @Column(name = "IsDeleted")
    protected Integer isDeleted;

    @Basic
    @Column(name = "DeleteBy")
    protected Long deleteBy;

    @Basic
    @Column(name = "DeleteTime")
    protected Date deleteTime;
}
