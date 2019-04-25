package com.liuhll.hl.common.domain.auditing;

import java.util.Date;


public interface IDeletionAudited extends  ISoftDelete  {
    long getDeleteBy();
    void setDeleteBy(long deleteBy);

    Date getDeleteTime();
    void setDeleteTime(Date deleteTime);
}
