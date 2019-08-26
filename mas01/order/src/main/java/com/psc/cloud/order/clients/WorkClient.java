package com.psc.cloud.order.clients;

import com.psc.cloud.order.config.ServerConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "work")
public interface WorkClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/svrConf",
            consumes = "application/json")
    ServerConfig getServerConfg();
}
