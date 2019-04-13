package com.liuhll.hl.identity.controller;

import com.liuhll.hl.identity.vo.LoginInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String Login(@RequestBody LoginInput input) {
        return "token";
    }
}
