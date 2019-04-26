package com.liuhll.hl.common.domain.auditing;

import java.util.Date;

public interface ICreationAudited {

    Long getCreateBy();

    void setCreateBy(Long createBy);

    Date getCreateTime();

    void  setCreateTime(Date createTime);
}
