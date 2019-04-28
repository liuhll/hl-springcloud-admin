package com.liuhll.hl.auth.typehandler;

import com.liuhll.hl.auth.domain.models.PoliticalStatus;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

public class PoliticalStatusTypeHandler extends EnumOrdinalTypeHandler<PoliticalStatus> {

    public PoliticalStatusTypeHandler(Class<PoliticalStatus> type) {
        super(type);
    }
}
