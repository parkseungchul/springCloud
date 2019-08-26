package com.psc.cloud.work.clients;

import com.psc.cloud.work.config.ServerConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "order")
public interface OrderClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/svrConf",
            consumes = "application/json")
    ServerConfig getServerConfg();
}
