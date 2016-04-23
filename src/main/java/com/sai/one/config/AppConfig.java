package com.sai.one.config;

import com.sai.one.dto.UserOptional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.sai.one")
class AppConfig {

    @Bean
    @Scope("prototype")
    public UserOptional userOptional() {
        return  new UserOptional();
    }
}