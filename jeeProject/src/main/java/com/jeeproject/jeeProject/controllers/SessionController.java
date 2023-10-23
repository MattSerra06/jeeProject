package com.jeeproject.jeeProject.controllers;

import com.jeeproject.jeeProject.repository.SessionRepository;
import com.jeeproject.jeeProject.resources.SessionResource;
import com.jeeproject.jeeProject.services.SessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionServiceImpl sessionServiceImpl;

    @GetMapping("/{id}")
    public SessionResource getSession(@PathVariable Long id){
        return sessionServiceImpl.getSession(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createSession(@RequestBody SessionResource sessionResource){
        try {
            SessionResource resource = sessionServiceImpl.createSession(sessionResource);
            return ResponseEntity.status(HttpStatus.CREATED).body(resource);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSession(@RequestBody SessionResource sessionResource){
        return null;
    }
}