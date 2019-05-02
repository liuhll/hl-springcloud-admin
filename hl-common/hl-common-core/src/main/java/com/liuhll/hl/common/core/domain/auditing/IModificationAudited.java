package com.liuhll.hl.common.core.domain.auditing;

import java.util.Date;

public interface IModificationAudited {

    Long getUpdateBy();

    void setUpdateBy(Long update);

    Date getUpdateTime();

    void setUpdateTime(Date updateTime);
}
