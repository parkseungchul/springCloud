package com.psc.cloud.protect2.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtectContoller {

    @RequestMapping(value={"", "/protect2"})
    public String getProtect(){
        return "protect2";
    }






}
