package com.jeeproject.jeeProject.controllers;

import com.jeeproject.jeeProject.repository.SessionRepository;
import com.jeeproject.jeeProject.resources.SessionResource;
import com.jeeproject.jeeProject.services.SessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionServiceImpl sessionServiceImpl;

    @GetMapping
    public Iterable<SessionResource> getSessions(){
        return sessionServiceImpl.getSessions();
    }

    @GetMapping("/{id}")
    public SessionResource getSession(@PathVariable Long id) {
        return sessionServiceImpl.getSession(id);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SESSION_MANAGER')")
    public ResponseEntity<Object> createSession(@RequestBody SessionResource sessionResource) {
        try {
            SessionResource resource = sessionServiceImpl.createSession(sessionResource);
            return ResponseEntity.status(HttpStatus.CREATED).body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SESSION_MANAGER')")
    public ResponseEntity<Object> updateSession(@RequestBody SessionResource sessionResource, @PathVariable Long id) {
        try {
            SessionResource resource = sessionServiceImpl.updateSession(sessionResource, id);
            return ResponseEntity.status(HttpStatus.OK).body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SESSION_MANAGER')")
    public ResponseEntity<Object> deleteSession(@PathVariable Long id) {
        try {
            sessionServiceImpl.deleteSession(id);
            return ResponseEntity.status(HttpStatus.OK).body("Session avec l'id :" + id + " supprimé");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Session avec l'id :"+id+" introuvable");
        }
    }
}
