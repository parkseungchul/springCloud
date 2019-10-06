package com.psc.cloud.product.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class ServerProperties {

    @Value("${env.init}")
    private String init;
}
