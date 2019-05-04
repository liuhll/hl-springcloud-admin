package com.liuhll.hl.basicdata.controller;

import com.liuhll.hl.basicdata.service.HlDictService;
import com.liuhll.hl.basicdata.vo.dict.CreateDictInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/dict")
public class DictionaryController {

    @Autowired
    private HlDictService hlDictService;

    @PostMapping
    public String CreateDict(@RequestBody CreateDictInput input){
        hlDictService.saveDict(input);
        return "新增字典值成功";
    }
}
