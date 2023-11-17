package com.jeeproject.jeeProject.spring.config;

import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestAppConfig {
    @Bean
    public SiteServiceImpl siteService() {
        return new SiteServiceImpl();
    }

    @Bean
    public SessionServiceImpl sessionService(){return new SessionServiceImpl();}
    @Bean
    public DisciplineServiceImpl disciplineService(){return new DisciplineServiceImpl();}

    @Bean
    public EpreuveServiceImpl epreuveService(){return new EpreuveServiceImpl();}

}
