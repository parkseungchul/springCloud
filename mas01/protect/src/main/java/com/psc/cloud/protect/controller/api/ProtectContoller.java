package com.psc.cloud.protect.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectContoller {

    @RequestMapping("/protect")
    public String getProtect(){
        return "protect";
    }
}
