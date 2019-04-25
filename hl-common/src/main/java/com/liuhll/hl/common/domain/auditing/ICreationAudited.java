package com.liuhll.hl.common.domain.auditing;

import java.util.Date;

public interface ICreationAudited {

    long getCreateBy();

    void setCreateBy(long createBy);

    Date getCreateTime();

    void  setCreateTime(Date createTime);
}
