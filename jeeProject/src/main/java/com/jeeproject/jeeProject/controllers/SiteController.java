package com.jeeproject.jeeProject.controllers;


import com.jeeproject.jeeProject.models.Site;
import com.jeeproject.jeeProject.resources.SiteResource;
import com.jeeproject.jeeProject.services.SiteServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/create")
    public ResponseEntity<String> createSite(@RequestBody SiteResource siteResource){
        try {
            siteServiceImpl.createSite(siteResource);
            return ResponseEntity.status(HttpStatus.CREATED).body("Site créé avec succès.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSite(@PathVariable("id") Long id,@RequestBody SiteResource siteResource){
        try{
            siteServiceImpl.updateSite(siteResource,id);
            return ResponseEntity.ok("Site mit à jour");
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
