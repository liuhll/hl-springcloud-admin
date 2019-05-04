package com.liuhll.hl.basicdata.client;

import com.liuhll.hl.basicdata.common.vo.GetSysConfigOutput;
import com.liuhll.hl.common.vo.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hl-basicdata")
public interface SysConfigClient {

    @GetMapping("/basicdata/v1/api/sysconf")
    ResponseResult<GetSysConfigOutput> getSysConfigByName(@RequestParam("confName") String confName);
}
