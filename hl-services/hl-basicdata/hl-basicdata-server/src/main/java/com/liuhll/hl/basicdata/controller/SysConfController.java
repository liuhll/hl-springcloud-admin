package com.liuhll.hl.basicdata.controller;

import com.liuhll.hl.basicdata.service.SysConfService;
import com.liuhll.hl.basicdata.vo.sysconf.CreateSysConfInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/sysconf")
public class SysConfController {

    @Autowired
    private SysConfService sysConfService;

    @PostMapping
    public String createSysConf(@RequestBody CreateSysConfInput input){
        sysConfService.saveSysConf(input);
        return "新增系统配置项成功";
    }
}
