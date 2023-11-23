package com.jeeproject.jeeProject.controllers;

import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.resources.DisciplineResource;
import com.jeeproject.jeeProject.services.DisciplineServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {
    @Autowired
    private DisciplineServiceImpl disciplineServiceImpl;

    @GetMapping
    public Iterable<DisciplineResource> getDisciplines(){return disciplineServiceImpl.getDisciplines();}

    @GetMapping("/{id}")
    public DisciplineResource getDiscipline(@PathVariable Long id){
        return disciplineServiceImpl.getDiscipline(id);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINISTRATIVE_MANAGER')")
    public ResponseEntity<Object> createDiscipline(@RequestBody DisciplineResource disciplineResource){
        try{
            DisciplineResource createdDisciplineResource = disciplineServiceImpl.createDiscipline(disciplineResource);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdDisciplineResource);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINISTRATIVE_MANAGER')")
    public ResponseEntity<Object> updateDiscipline(@PathVariable("id") Long id,@RequestBody DisciplineResource disciplineResource){
        try{
            DisciplineResource updatedDisciplineResource = disciplineServiceImpl.updateDiscipline(disciplineResource,id);
            return ResponseEntity.status(HttpStatus.OK).body(updatedDisciplineResource);
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINISTRATIVE_MANAGER')")
    public ResponseEntity<Object> deleteDiscipline(@PathVariable("id") Long id){
        try{
            disciplineServiceImpl.deleteDiscipline(id);
            return ResponseEntity.status(HttpStatus.OK).body("Discipline avec l'id :"+id+" supprimé");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Discipline avec l'id :"+id+" introuvable");
        }
    }
}
