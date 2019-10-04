package com.psc.cloud.discovery;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication  implements CommandLineRunner, ApplicationListener {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    EurekaClientConfigBean eurekaClientConfigBean;

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Map<String,String> map = eurekaClientConfigBean.getServiceUrl();
        log.debug(map.toString());

    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            int port = applicationContext.getBean(Environment.class).getProperty("server.port", Integer.class, 8080);
            String hostPort = String.format("%s:%d", ip, port);
            Map<String, String> map = new HashMap<String,String>();
            map.put("defaultZone", "http://"+hostPort+"/eureka/");
            eurekaClientConfigBean.setServiceUrl(map);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
