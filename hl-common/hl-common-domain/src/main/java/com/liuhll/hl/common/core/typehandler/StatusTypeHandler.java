package com.liuhll.hl.common.core.typehandler;

import com.liuhll.hl.common.core.domain.models.Status;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

public class StatusTypeHandler extends EnumOrdinalTypeHandler<Status> {

    public StatusTypeHandler(Class<Status> type) {
        super(type);
    }
}
