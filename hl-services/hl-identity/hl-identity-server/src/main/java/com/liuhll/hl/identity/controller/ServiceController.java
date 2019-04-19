package com.liuhll.hl.identity.controller;

import com.liuhll.hl.common.annotation.IgnoreResponseAdvice;
import com.liuhll.hl.identity.conf.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/v1")
@RestController
public class ServiceController {

    @Autowired
    private JwtConfig jwtConfig;

    @IgnoreResponseAdvice
    @GetMapping("/service/allowedclients")
    public List<String> getAllowedClients(@RequestParam String clientId, @RequestParam String secret){
        //:todo validateClientKey
        return Arrays.asList("hl-organization", "hl-product");
    }
}
