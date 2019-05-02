package com.liuhll.hl.common.exception;

import com.liuhll.hl.common.enums.ResultCode;

public class UnAuthorizedException extends HlException {
    public UnAuthorizedException(String errorMessage){
        super(errorMessage, ResultCode.UnAuthorized);
    }
}
