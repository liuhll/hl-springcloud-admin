package com.liuhll.hl.common.exception;

import com.liuhll.hl.common.enums.ResultCode;

public class ClientForbiddenException extends HlException {

    public ClientForbiddenException(String exceptionMessage) {
        super(exceptionMessage, ResultCode.ClentForbidden);
    }
}
