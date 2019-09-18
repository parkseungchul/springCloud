package com.psc.cloud.protect.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user")
    public String getUser(){
        return "user service";
    }

    @GetMapping("/protect2/user")
    public String getProtect2User(){

        return "user";
        //return protect2Client.getProtect2User();
    }
}
