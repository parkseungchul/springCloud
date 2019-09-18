package com.psc.cloud.protect.controller.api;

import com.psc.cloud.protect.clients.Protect2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private Protect2Client protect2Client;

    @GetMapping("/user")
    public String getUser(){
        return "protect user";
    }

    @GetMapping("/protect2/user")
    public String getProtect2User(){
        return protect2Client.getProtect2User();
    }

    @GetMapping("/protect2/user2admin")
    public String getProtect2User2(){
        return protect2Client.getProtect2Admin();
    }
}
