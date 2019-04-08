package com.liuhll.hl.exception;

import com.liuhll.hl.enums.ResultCode;

public class UnAuthorizedException extends HlException {
    public UnAuthorizedException(String errorMessage){
        super(errorMessage, ResultCode.UnAuthorized);
    }
}
