package com.jeeproject.jeeProject.controllers;

import com.jeeproject.jeeProject.resources.EpreuveResource;
import com.jeeproject.jeeProject.services.EpreuveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epreuve")
public class EpreuveController {

    @Autowired
    private EpreuveServiceImpl epreuveServiceImpl;

    @GetMapping
    public Iterable<EpreuveResource> getEpreuves(){
        return epreuveServiceImpl.getEpreuves();
    }

    @GetMapping("/{id}")
    public EpreuveResource getEpreuve(@PathVariable Long id){return epreuveServiceImpl.getEpreuve(id);}

    @PostMapping("/create")
    public ResponseEntity<Object> createEpreuve(@RequestBody EpreuveResource epreuveResource){
        try{
            EpreuveResource resource = epreuveServiceImpl.createEpreuve(epreuveResource);
            return ResponseEntity.status(HttpStatus.CREATED).body(resource);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEpreuve(@RequestBody EpreuveResource epreuveResource, @PathVariable Long id){
        try{
            EpreuveResource resource = epreuveServiceImpl.updateEpreuve(epreuveResource,id);
            return ResponseEntity.status(HttpStatus.OK).body(resource);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEpreuve(@PathVariable Long id){
        try {
            epreuveServiceImpl.deleteEpreuve(id);
            return ResponseEntity.status(HttpStatus.OK).body("Epreuve avec l'id :" + id + " supprimé");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Epreuve avec l'id :"+id+" introuvable");

        }
    }

    @GetMapping("/disciplines")
    public ResponseEntity<Object> getAllEpreuveByDiscipline(){
        try {
            Iterable<EpreuveResource> epreuveResources = epreuveServiceImpl.getAllEpreuvesByDiscipline();
            System.out.println(epreuveResources);
            return ResponseEntity.status(HttpStatus.OK).body(epreuveResources);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Aucune épreuve trouvé pour les disciplines");
        }
    }
}