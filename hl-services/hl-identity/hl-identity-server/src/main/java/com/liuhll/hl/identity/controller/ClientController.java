package com.liuhll.hl.identity.controller;

import com.liuhll.hl.common.annotation.IgnoreResponseAdvice;
import com.liuhll.hl.identity.conf.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/client")
@RestController
public class ClientController {

    @Autowired
    private JwtConfig jwtConfig;

    @GetMapping("/jwtsecret")
    @IgnoreResponseAdvice
    public String getJwtSecret(@RequestParam String clientId, @RequestParam String secret){
        //:todo validateClientKey
        return jwtConfig.getSecret();
    }
}
