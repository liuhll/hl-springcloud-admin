package com.liuhll.hl.exception;

import com.liuhll.hl.enums.ResultCode;

public class BussinessException extends HlException {

    public BussinessException(String errorMesage){
        super(errorMesage, ResultCode.BusinessError);
    }
}