package com.liuhll.hl.common.core.exception;

import com.liuhll.hl.common.core.enums.ResultCode;

public class ClientForbiddenException extends HlException {

    public ClientForbiddenException(String exceptionMessage) {
        super(exceptionMessage, ResultCode.ClentForbidden);
    }
}
