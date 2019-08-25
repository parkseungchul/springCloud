package com.psc.cloud.discoverysvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverysvrApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoverysvrApplication.class, args);
    }

}
