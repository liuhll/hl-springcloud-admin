package com.liuhll.hl.common.core.exception;


import com.liuhll.hl.common.core.enums.ResultCode;

public class UnAuthenticationException extends HlException {

    public UnAuthenticationException(String errorMessage){
        super(errorMessage, ResultCode.UnAuthentication);
    }

}
