package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.models.Site;
import com.jeeproject.jeeProject.resources.SiteResource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface SiteService {
    public Iterable<Site> getSites();
    public SiteResource createSite(SiteResource siteResource) throws IOException;

    public SiteResource updateSite(SiteResource siteResource, Long id);

    public void deleteSite(Long id);
}
