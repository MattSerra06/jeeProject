package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.models.Site;
import com.jeeproject.jeeProject.repository.SessionRepository;
import com.jeeproject.jeeProject.resources.SiteResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StatistiqueServiceImpl implements StatistiqueService{

    @Autowired
    private SessionRepository sessionRepository;
    @Override
    public List<Object[]> getSiteWithMostSession() {
        return sessionRepository.findTop5SitesBySessionCount();
    }
}
