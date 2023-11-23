package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.resources.SiteResource;

import java.util.List;

public interface StatistiqueService {
    public List<Object[]> getSiteWithMostSession();
}
