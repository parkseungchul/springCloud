package com.psc.cloud.order.controller.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @GetMapping("")
    public String index(){
        return "hello order";
    }

    @GetMapping("/svrConf/{appName}")
    public ServerConfig getServerConfig(@PathVariable("appName") String appName){
        if(appName.equals("work")){
            return workClient.getServerConfg();
        }
        return serverConfig;
    }

    @HystrixCommand(
            fallbackMethod = "circuitBreakerFallback",
            commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "5000")
            },
            threadPoolKey = "circuitPool",
            threadPoolProperties = {
            @HystrixProperty(name="coreSize", value= "30"),
            @HystrixProperty(name="maxQueueSize", value = "10")
            }
     )
    @GetMapping("/circuitBreaker/{time}")
    public String circuitBreaker(@PathVariable("time") String time) throws Exception{

        int ntime = Integer.parseInt(time);

        try{
            Thread.sleep(ntime * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "circuitBreaker";
    }

    public String circuitBreakerFallback(String time){
        return "fallback";
    }


}
