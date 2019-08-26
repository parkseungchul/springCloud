package com.psc.cloud.order.controller.api;

import com.psc.cloud.order.clients.WorkClient;
import com.psc.cloud.order.config.ServerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ConfigController {

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private WorkClient workClient;

    @GetMapping("/svrConf/{appName}")
    public ServerConfig getServerConfig(@PathVariable("appName") String appName){
        if(appName.equals("work")){
            return workClient.getServerConfg();
        }
        return serverConfig;
    }
}
