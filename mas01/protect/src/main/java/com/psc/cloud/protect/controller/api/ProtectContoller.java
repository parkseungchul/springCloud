package com.psc.cloud.protect.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtectContoller {

    @RequestMapping("")
    public String getProtect(){
        return "this protect resource";
    }
}
