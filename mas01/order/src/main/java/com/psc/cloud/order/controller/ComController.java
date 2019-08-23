package com.psc.cloud.order.controller;

import com.psc.cloud.order.config.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComController {

    @Autowired
    private ServerConfig serverConfig;

    @RequestMapping("/test")
    public ServerConfig getTest(){
        return serverConfig;
    }
}
