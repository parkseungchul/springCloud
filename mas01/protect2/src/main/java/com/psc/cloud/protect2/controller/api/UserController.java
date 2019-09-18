package com.psc.cloud.protect2.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping(value={"/user", "/protect2/user"})
    public String getUser(){
        return "protect2 user";
    }
}
