package com.liuhll.hl.common.domain.auditing;

import java.util.Date;


public interface IDeletionAudited extends  ISoftDelete  {
    long getDeleteUserId();
    void setDeleteUserId(long deleteUserId);

    Date getDeleteTime();
    void setDeleteTime(Date deletetionTime);
}
