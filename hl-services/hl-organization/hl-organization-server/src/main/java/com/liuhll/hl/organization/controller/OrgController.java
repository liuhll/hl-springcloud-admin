package com.liuhll.hl.organization.controller;

import com.liuhll.hl.common.auth.runtime.session.HlContextSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/org")
public class OrgController {

    @GetMapping
    public String hello(){

        String currentUser = HlContextSession.getUserId();
        return "hello org";
    }
}
