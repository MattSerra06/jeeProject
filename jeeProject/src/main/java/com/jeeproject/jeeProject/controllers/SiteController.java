package com.jeeproject.jeeProject.controllers;


import com.jeeproject.jeeProject.models.Site;
import com.jeeproject.jeeProject.resources.SiteResource;
import com.jeeproject.jeeProject.services.SiteServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/site")
public class SiteController {
    @Autowired
    private SiteServiceImpl siteServiceImpl;

    @GetMapping
    public Iterable<Site> getSites(){
        return siteServiceImpl.getSites();
    }

    @GetMapping("/{id}")
    public SiteResource getSite(@PathVariable Long id){
        return siteServiceImpl.getSite(id);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Object> createSite(@RequestBody SiteResource siteResource){
        try {
            SiteResource createdSiteResource = siteServiceImpl.createSite(siteResource);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSiteResource);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSite(@PathVariable("id") Long id,@RequestBody SiteResource siteResource){
        try{
            SiteResource updatedSiteResource = siteServiceImpl.updateSite(siteResource,id);
            return ResponseEntity.status(HttpStatus.OK).body(updatedSiteResource);
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSite(@PathVariable("id") Long id){
        try{
            siteServiceImpl.deleteSite(id);
            return ResponseEntity.status(HttpStatus.OK).body("Site avec l'id :"+id+" supprimé");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Site avec l'id :"+id+" introuvable");
        }
    }

}
