package com.liuhll.hl.exception;


import com.liuhll.hl.enums.ResultCode;

public class UnAuthenticationException extends HlException {

    public UnAuthenticationException(String errorMessage){
        super(errorMessage, ResultCode.UnAuthentication);
    }

}
