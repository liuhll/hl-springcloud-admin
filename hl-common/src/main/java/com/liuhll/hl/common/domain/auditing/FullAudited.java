package com.liuhll.hl.common.domain.auditing;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

@Data
public abstract class FullAudited extends CreationAudited {
    @Basic
    @Column(name = "update_by")
    private Long updateBy;

    @Basic
    @Column(name = "update_time")
    private Date updateTime = new Date();
}
