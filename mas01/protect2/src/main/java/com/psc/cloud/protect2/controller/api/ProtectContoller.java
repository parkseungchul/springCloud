package com.psc.cloud.protect2.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtectContoller {

    @RequestMapping("")
    public String getProtect(){
        return "this protect2 resource";
    }

    @RequestMapping("/protect2")
    public String getProtect2(){
        return "FeignClient protect2";
    }
}
