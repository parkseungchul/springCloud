package com.psc.cloud.protect.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                .antMatchers(HttpMethod.GET, "/api/admin")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/protect2/admin")
                .hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/api/user")
                .hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/protect2/user")
                .hasAnyRole("USER", "ADMIN")

                .anyRequest()
                .authenticated();

    }
}
