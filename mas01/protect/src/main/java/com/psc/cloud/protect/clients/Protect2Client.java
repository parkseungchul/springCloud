package com.psc.cloud.protect.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "protect2", configuration = {Protect2ClientHeader.class})
public interface Protect2Client {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/protect2",
            consumes = "application/json")
    String getProtect2();

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/protect2/admin",
            consumes = "application/json")
    String getProtect2Admin();

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/protect2/user",
            consumes = "application/json")
    String getProtect2User();
}
