package com.liuhll.hl.auth.typehandler;

import com.liuhll.hl.auth.domain.models.UserLocked;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

public class UserLockedTypeHandler extends EnumOrdinalTypeHandler<UserLocked> {
    public UserLockedTypeHandler(Class<UserLocked> type) {
        super(type);
    }
}
