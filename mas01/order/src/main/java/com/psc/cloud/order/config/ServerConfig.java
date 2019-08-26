package com.psc.cloud.order.config;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@RefreshScope
@JsonSerialize(as=ServerConfig.class)
public class ServerConfig{

    // 활성화 된 프로파일 이름
    @Value("${spring.profiles.active}")
    private String profilesActive;

    // 바라봐야 하는 서비스(어플리케이션 이름)
    @Value("${spring.application.name}")
    private String appName;

    // 컴피그 서버에서 가져오는 값
    @Value("${service.name}")
    private String serviceName;

    // 컴피그 서버에서 가져오는 값
    @Value("${service.local}")
    private String serviceLocal;
}
