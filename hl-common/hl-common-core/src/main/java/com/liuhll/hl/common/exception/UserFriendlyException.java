package com.liuhll.hl.common.exception;

import com.liuhll.hl.common.enums.ResultCode;

public class UserFriendlyException extends HlException {

    public UserFriendlyException(String exceptionMessage) {
        super(exceptionMessage, ResultCode.FriendlyTips);
    }
}
