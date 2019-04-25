package com.liuhll.hl.common.domain.auditing;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

@Data
public abstract class DeletionAudited implements IDeletionAudited {

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
