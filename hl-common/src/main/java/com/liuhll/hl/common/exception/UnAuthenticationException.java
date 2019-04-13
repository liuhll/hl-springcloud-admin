package com.liuhll.hl.common.exception;


import com.liuhll.hl.common.enums.ResultCode;

public class UnAuthenticationException extends HlException {

    public UnAuthenticationException(String errorMessage){
        super(errorMessage, ResultCode.UnAuthentication);
    }

}
