package com.liuhll.hl.common.core.domain.auditing;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

@Data
public abstract class ModificationAudited  implements IModificationAudited{

    @Basic
    @Column(name = "updateBy")
    private Long updateBy;

    @Basic
    @Column(name = "updateTime")
    private Date updateTime;
}
