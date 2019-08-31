package com.psc.cloud.work.controller.api;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.psc.cloud.work.clients.OrderClient;
import com.psc.cloud.work.config.ServerConfig;
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
    private OrderClient orderClient;

    @GetMapping("")
    public ServerConfig index(){
        return serverConfig;
    }

    @GetMapping("/svrConf/{appName}")
    public ServerConfig getServerConfig(@PathVariable("appName") String appName){
        if(appName.equals("order")){
            ServerConfig serverConfig2 = orderClient.getServerConfg();
            serverConfig2.setLocal("remote");
            return serverConfig2;
        }
        serverConfig.setLocal("local");
        return serverConfig;
    }

    @GetMapping("/circuitBreaker")
    public String circuitBreaker() throws Exception{

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "circuitBreaker";
    }
}
