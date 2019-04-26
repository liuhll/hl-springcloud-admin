package com.liuhll.hl.common.exception;

import com.liuhll.hl.common.enums.ResultCode;

public class ClientAuthException extends HlException {

    public ClientAuthException(String exceptionMessage) {
        super(exceptionMessage, ResultCode.NonExistentClent);
    }
}
