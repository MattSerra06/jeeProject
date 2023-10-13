package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.mappers.SiteMapper;
import com.jeeproject.jeeProject.models.Site;
import com.jeeproject.jeeProject.repository.SiteRepository;
import com.jeeproject.jeeProject.resources.SiteResource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class SiteServiceImpl implements SiteService {
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private SiteMapper siteMapper;

    public Iterable<Site> getSites(){//Faut transformer ça en SiteResource à renvoyer
        return siteRepository.findAll();
    }

    @Override
    public SiteResource getSite(Long id) {
        Site site = siteRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Site not found in db with id :"+id));
        return siteMapper.siteToSiteResource(site);
    }

    public SiteResource createSite(SiteResource siteResource) throws IOException {
        Site site = siteMapper.siteResourceToSite(siteResource);
        if(!estEnDB(siteResource)){
            siteRepository.save(site);
        }else{
            throw new IOException("Site déjà présent en DB");
        }
        return siteMapper.siteToSiteResource(site);
    }

    public SiteResource updateSite(SiteResource siteResource,Long id){
        Site site = siteRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Site not found in db with id :"+id));
        siteMapper.updateSiteFromResource(siteResource,site);
        siteRepository.save(site);
        return siteMapper.siteToSiteResource(site);
    }

    public void deleteSite(Long id){
        siteRepository.deleteById(id);
    }

    private boolean estEnDB(SiteResource siteResource){
        return siteRepository.existsByNomAndVilleAndCategorie(siteResource.getNom(),siteResource.getVille(),siteResource.getCategorie());
    }
}
