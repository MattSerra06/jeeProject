package com.jeeproject.jeeProject.spring.config;

import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.services.DisciplineService;
import com.jeeproject.jeeProject.services.DisciplineServiceImpl;
import com.jeeproject.jeeProject.services.SiteServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestAppConfig {
    @Bean
    public SiteServiceImpl siteService() {
        return new SiteServiceImpl();
    }
    @Bean
    public DisciplineServiceImpl disciplineService(){return new DisciplineServiceImpl();}

}
