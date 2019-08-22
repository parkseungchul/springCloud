package com.psc.cloud.order.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ServerConfig {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.profiles.active}")
    private String profilesActive;

    @Value("${service.name}")
    private String serviceName;

    @Value("${service.local}")
    private String serviceLocal;
}
