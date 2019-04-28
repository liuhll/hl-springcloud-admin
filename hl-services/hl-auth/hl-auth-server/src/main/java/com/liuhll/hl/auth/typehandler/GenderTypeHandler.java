package com.liuhll.hl.auth.typehandler;

import com.liuhll.hl.auth.domain.models.Gender;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

public class GenderTypeHandler extends EnumOrdinalTypeHandler<Gender> {
    public GenderTypeHandler(Class<Gender> clazz){
        super(clazz);
    }
}
