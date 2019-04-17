package com.liuhll.hl.identity.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${auth.service-id}")
public interface ServiceAuthClient {

    @RequestMapping(value = "/identity/v1/client/jwtsecret",method = RequestMethod.GET)
    String getJwtSecret(@RequestParam("clientId") String clientId,@RequestParam("secret") String secret);
}
