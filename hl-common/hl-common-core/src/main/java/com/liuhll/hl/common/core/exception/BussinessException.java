package com.liuhll.hl.common.core.exception;

import com.liuhll.hl.common.core.enums.ResultCode;

public class BussinessException extends HlException {

    public BussinessException(String errorMesage){
        super(errorMesage, ResultCode.BusinessError);
    }
}
