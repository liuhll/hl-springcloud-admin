package com.liuhll.hl.basicdata.controller;

import com.liuhll.hl.basicdata.common.vo.GetSysConfigOutput;
import com.liuhll.hl.basicdata.domain.entity.Systemconf;
import com.liuhll.hl.basicdata.service.SysConfService;
import com.liuhll.hl.basicdata.vo.sysconf.CreateSysConfInput;
import com.liuhll.hl.common.exception.BussinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public GetSysConfigOutput getSysConfigByName(@RequestParam String confName){
        Systemconf query =new Systemconf();
        query.setConfigName(confName);
        Systemconf queryData = sysConfService.seleceOne(query);
        if (queryData == null){
            throw new BussinessException("不存在名称为".concat(confName).concat("的配置项"));
        }
        GetSysConfigOutput output = new GetSysConfigOutput();
        BeanUtils.copyProperties(queryData,output);
        return output;
    }
}
