package com.psc.cloud.product.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Slf4j
@Configuration
public class SpringReady {

    @Autowired
    private ServerProperties serverProperties;

    @EventListener(ApplicationReadyEvent.class)
    public void startup(){
        log.info("★★★[" + serverProperties.toString() + "]★★★");
    }

}
