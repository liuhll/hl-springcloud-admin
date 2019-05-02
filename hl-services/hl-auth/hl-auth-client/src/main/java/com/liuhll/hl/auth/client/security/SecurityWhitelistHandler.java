package com.liuhll.hl.auth.client.security;

import com.liuhll.hl.common.auth.conf.SecurityWhitelistConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class SecurityWhitelistHandler implements ISecurityWhitelistHandler {

    @Autowired
    private SecurityWhitelistConfig securityWhitelistConfig;
    @Override
    public boolean isPermitAuth(String webApi) {
        return securityWhitelistConfig.getWhitelist().stream().anyMatch(p-> Pattern.matches(p,webApi));
    }
}
