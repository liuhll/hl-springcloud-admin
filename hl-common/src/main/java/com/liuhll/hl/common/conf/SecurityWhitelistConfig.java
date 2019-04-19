package com.liuhll.hl.common.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "auth")
public class SecurityWhitelistConfig {

    List<String> whitelist;

    public List<String> getWhitelist(){
        if (whitelist == null){
            return new ArrayList<>();
        }
        return whitelist;
    }

}

