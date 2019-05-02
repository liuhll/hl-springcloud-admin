package com.liuhll.hl.common.core.exception;

import com.liuhll.hl.common.core.enums.ResultCode;

public class UserFriendlyException extends HlException {

    public UserFriendlyException(String exceptionMessage) {
        super(exceptionMessage, ResultCode.FriendlyTips);
    }
}
