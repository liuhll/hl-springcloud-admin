package com.liuhll.hl.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api("ProductController")
@RestController
public class ProductController {

    @ApiOperation(value="hello", notes="hello demo")

    @GetMapping("/hello")
    public String helloWord(@RequestParam(required = false) String name){
        return "Hello " + name;
    }
}
