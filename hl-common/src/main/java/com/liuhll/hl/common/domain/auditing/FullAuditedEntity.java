package com.liuhll.hl.common.domain.auditing;

import lombok.Data;

import java.util.Date;

@Data
public class FullAuditedEntity extends AuditedEntity implements IDeletionAudited {

    private int isDeleted;

    private long deleteUserId;

    private Date DeleteTime;
}
