package com.psc.cloud.work.controller.api;

import com.psc.cloud.work.config.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConfigController {

    @Autowired
    private ServerConfig serverConfig;

    @GetMapping("/svrConf")
    public ServerConfig getServerConfig(){
        return serverConfig;
    }
}
