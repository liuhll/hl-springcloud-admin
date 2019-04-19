package com.liuhll.hl.common.security;

import com.liuhll.hl.common.conf.SecurityWhitelistConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class SecurityWhitelistHandlerImpl implements SecurityWhitelistHandler {

    @Autowired
    private SecurityWhitelistConfig whitelistConfig;
    @Override
    public boolean isPermitAuth(String webApi) {
        return whitelistConfig.getWhitelist().stream().anyMatch(p-> Pattern.matches(p,webApi));
    }
}
