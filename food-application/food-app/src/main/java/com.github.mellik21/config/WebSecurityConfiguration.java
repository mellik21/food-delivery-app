/*
package com.github.mellik21.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                .and()
                .oauth2Login()
                    .redirectionEndpoint()
                    .baseUri("/");
    }

    @Bean
    public GrantedAuthoritiesMapper authoritiesMapper() {
        return authorities -> authorities;
    }
}
*/
