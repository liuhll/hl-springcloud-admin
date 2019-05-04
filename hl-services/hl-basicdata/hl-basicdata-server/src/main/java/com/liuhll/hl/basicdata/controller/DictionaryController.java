package com.liuhll.hl.basicdata.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/dict")
public class DictionaryController {

    @PostMapping
    public String AddDic(){
        return "Ok";
    }
}
