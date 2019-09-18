package com.psc.cloud.protect.controller.api;

import com.psc.cloud.protect.clients.Protect2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtectContoller {

    @Autowired
    Protect2Client protect2Client;

    @RequestMapping("")
    public String getProtect(){
        return "this protect resource";
    }

    @GetMapping("/protect2")
    public String getProtect2(){
        return protect2Client.getProtect2();
    }
}
