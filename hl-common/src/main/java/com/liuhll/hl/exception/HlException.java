package com.liuhll.hl.exception;

import com.liuhll.hl.enums.ResultCode;

public class HlException extends Exception {

    public HlException(String exceptionMessage, ResultCode errorCode){
        super(exceptionMessage);
        this.code = errorCode;
    }


    private ResultCode code;

    public ResultCode getCode(){
        return code;
    }

}