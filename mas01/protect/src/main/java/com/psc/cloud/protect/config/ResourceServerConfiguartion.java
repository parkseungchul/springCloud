package com.psc.cloud.protect.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfiguartion extends ResourceServerConfigurerAdapter {
    private static final String[] EXCLUDE_PATHS = {
            "/actuator"
    };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().anyRequest().authenticated();
        http
                .authorizeRequests()

                .antMatchers(HttpMethod.GET, "/actuator")
                .anonymous()
                .antMatchers(HttpMethod.GET, "/actuator")
                .permitAll()

                .antMatchers(HttpMethod.GET, "/api")
                .anonymous()
                .antMatchers(HttpMethod.GET, "/api")
                .permitAll()

                .antMatchers(HttpMethod.GET, "/api/protect2")
                .anonymous()
                .antMatchers(HttpMethod.GET, "/api/protect2")
                .permitAll()

                .antMatchers(HttpMethod.GET, "/api/admin")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()

                .antMatchers(HttpMethod.GET, "/api/user")
                .hasAnyRole("USER", "ADMIN")
                .anyRequest()
                .authenticated();


    }
}
