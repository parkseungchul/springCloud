package com.psc.cloud.protect.controller.api;

import com.psc.cloud.protect.clients.Protect2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private Protect2Client protect2Client;

    @GetMapping("/admin")
    public String getAdmin(){
        return "protect admin";
    }

    @GetMapping("/protect2/admin")
    public String getProtect2Admin(){

        return protect2Client.getProtect2Admin();
    }

    @GetMapping("/protect2/admin2user")
    public String getProtect2Admin2User(){
        return protect2Client.getProtect2User();
    }


}
