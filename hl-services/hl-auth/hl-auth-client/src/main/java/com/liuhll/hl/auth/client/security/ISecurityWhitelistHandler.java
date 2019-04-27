package com.liuhll.hl.auth.client.security;

public interface ISecurityWhitelistHandler {
    boolean isPermitAuth(String webApi);
}
