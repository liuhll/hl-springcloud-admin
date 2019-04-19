package com.liuhll.hl.common.security;

public interface SecurityWhitelistHandler {
    boolean isPermitAuth(String webApi);
}
