package com.psc.cloud.svcgate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ServiceConfig {
//  @Value("${signing.key}")
  private String jwtSigningKey="1234567890";


  public String getJwtSigningKey() {
    return jwtSigningKey;
  }

}
