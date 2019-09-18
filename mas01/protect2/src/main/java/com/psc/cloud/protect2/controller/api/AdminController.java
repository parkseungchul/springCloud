package com.psc.cloud.protect2.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {

    @GetMapping("/admin")
    public String getAdmin(){
        return "protect2 admin";
    }

    @RequestMapping("/protect2/admin")
    public String getProtect2Admin(){
        return "protect2 admin";
    }
}
