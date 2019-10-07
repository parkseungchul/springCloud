package com.psc.cloud.product.config;

import com.psc.cloud.product.init.InitData;
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

    @Autowired
    private InitData initData;

    @EventListener(ApplicationReadyEvent.class)
    public void startup(){
        if(serverProperties.isInit()) {
            initData.deleteAll();
            initData.saveAll();
        }
    }
}
