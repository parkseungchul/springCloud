package com.psc.cloud.protect.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {

    @RequestMapping("/admin")
    public String getAdmin(){
        return "admin service";
    }
}
