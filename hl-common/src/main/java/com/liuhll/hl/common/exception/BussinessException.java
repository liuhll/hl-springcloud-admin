package com.liuhll.hl.common.exception;

import com.liuhll.hl.common.enums.ResultCode;

public class BussinessException extends HlException {

    public BussinessException(String errorMesage){
        super(errorMesage, ResultCode.BusinessError);
    }
}
