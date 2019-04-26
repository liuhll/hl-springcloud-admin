package com.liuhll.hl.common.domain.auditing;

import lombok.Data;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

@Data
public abstract class DeletionAudited implements IDeletionAudited {

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
