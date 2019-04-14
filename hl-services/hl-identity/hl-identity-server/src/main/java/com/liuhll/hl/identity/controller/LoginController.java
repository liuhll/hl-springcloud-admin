package com.liuhll.hl.identity.controller;

import com.liuhll.hl.common.exception.UnAuthenticationException;
import com.liuhll.hl.identity.domain.service.AuthService;
import com.liuhll.hl.identity.vo.LoginInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class LoginController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String Login(@RequestBody LoginInput input) throws UnAuthenticationException {
        return authService.login(input.getUserName(), input.getPassword());
    }

    @GetMapping("/api/user/{id}")
    public String UserInfo(@PathVariable String id) {
        return "liuhll";
    }
}
