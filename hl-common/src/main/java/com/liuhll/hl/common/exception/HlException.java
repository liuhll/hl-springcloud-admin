package com.liuhll.hl.common.exception;

import com.liuhll.hl.common.enums.ResultCode;

public class HlException extends RuntimeException {

    public HlException(String exceptionMessage, ResultCode errorCode){
        super(exceptionMessage);
        this.code = errorCode;
    }


    private ResultCode code;

    public ResultCode getCode(){
        return code;
    }

}
