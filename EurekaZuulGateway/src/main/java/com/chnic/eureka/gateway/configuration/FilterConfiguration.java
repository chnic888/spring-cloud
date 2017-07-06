package com.chnic.eureka.gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chnic.eureka.gateway.filter.AuthenticationFilter;

@Configuration
public class FilterConfiguration {

	@Bean
    public AuthenticationFilter authenticationFilter() {
        return new AuthenticationFilter();
    }
}
