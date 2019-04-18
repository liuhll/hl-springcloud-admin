package com.liuhll.hl.identity.client.feign;

import com.liuhll.hl.common.vo.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${auth.service-id}")
public interface ServiceAuthClient {

    @RequestMapping(value = "/identity/v1/client/jwtsecret",method = RequestMethod.GET)
    ResponseResult<String> getJwtSecret(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);

    //                       /identity/v1/service/allowedclients
    @RequestMapping(value = "/identity/v1/service/allowedclients",method = RequestMethod.GET)
    List<String> getAllowedClients(@RequestParam("clientId")String clientId,@RequestParam("secret") String secret);
}
