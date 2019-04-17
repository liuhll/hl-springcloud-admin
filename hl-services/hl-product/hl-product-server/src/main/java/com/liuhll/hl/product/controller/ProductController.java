package com.liuhll.hl.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    @GetMapping("/hello")
    public String helloWord(@RequestParam(required = false) String name){
        return "Hello " + name;
    }
}
