package com.liuhll.hl.common.core.exception;

import com.liuhll.hl.common.core.enums.ResultCode;

public class ClientAuthException extends HlException {

    public ClientAuthException(String exceptionMessage) {
        super(exceptionMessage, ResultCode.NonExistentClent);
    }
}
