package com.liuhll.hl.common.enums;

import lombok.Getter;

@Getter
public enum ResultCode {
    Ok(0,"成功"),
    UnAuthentication(1,"未认证"),
    UnAuthorized(2,"未授权"),
    BusinessError(3,"业务异常"),
    PlatformException(4,"框架异常"),
    FriendlyTips(5,""),
    ClentForbidden(6,"无权访问该应用")
    ;

    private int code;
    private String memo;

    ResultCode(int code, String memo){
        this.code = code;
        this.memo = memo;

    }

    @Override
    public String toString() {
        return memo;
    }
}

