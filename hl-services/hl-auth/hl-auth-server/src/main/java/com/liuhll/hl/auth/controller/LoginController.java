package com.liuhll.hl.auth.controller;

import com.liuhll.hl.common.exception.UnAuthenticationException;
import com.liuhll.hl.auth.client.annotation.IgnoreUserToken;
import com.liuhll.hl.auth.service.IAuthService;
import com.liuhll.hl.auth.vo.LoginInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class LoginController {

    @Autowired
    private IAuthService IAuthService;

    @PostMapping("/login")
    @IgnoreUserToken
    public String Login(@RequestBody LoginInput input) throws UnAuthenticationException {
        return IAuthService.login(input.getUserName(), input.getPassword());
    }

    @GetMapping("/api/user/{id}")
    public String UserInfo(@PathVariable String id) {
        return "liuhll";
    }
}
