package com.liuhll.hl.common.domain.auditing;

import java.util.Date;

public interface IModificationAudited {

    long getUpdateBy();

    void setUpdateBy(long updateBy);

    Date getUpdateTime();

    void setUpdateTime();
}
