package com.liuhll.hl.identity.controller;

import com.liuhll.hl.identity.vo.LoginInput;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String Login(@RequestBody LoginInput input) {
        return "token";
    }

    @GetMapping("/user/{id}")
    public String UserInfo(@PathVariable String id){
        return "liuhll";
    }
}
