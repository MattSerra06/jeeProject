package com.jeeproject.jeeProject.spring.config;

import com.jeeproject.jeeProject.services.SiteServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestAppConfig {
    @Bean
    public SiteServiceImpl siteService() {
        return new SiteServiceImpl();
    }
}
