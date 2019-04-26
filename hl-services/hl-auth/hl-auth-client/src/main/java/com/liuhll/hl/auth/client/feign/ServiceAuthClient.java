package com.liuhll.hl.auth.client.feign;

import com.liuhll.hl.common.vo.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${auth.service-id}")
public interface ServiceAuthClient {


    @RequestMapping(value = "/auth/v1/service/allowedclients",method = RequestMethod.POST)
    List<String> getAllowedClients(@RequestParam("clientId")String clientId,@RequestParam("secret") String secret);

    @RequestMapping(value = "/auth/v1/service/jwtsecret",method = RequestMethod.POST)
    ResponseResult<String> getJwtSecret(@RequestParam("clientId")String clientId, @RequestParam("secret") String secret);
}
