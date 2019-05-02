package com.liuhll.hl.common.core.exception;

import com.liuhll.hl.common.core.enums.ResultCode;

public class UnAuthorizedException extends HlException {
    public UnAuthorizedException(String errorMessage){
        super(errorMessage, ResultCode.UnAuthorized);
    }
}
