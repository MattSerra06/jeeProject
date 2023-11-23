package com.jeeproject.jeeProject.controllers;

import com.jeeproject.jeeProject.models.Site;
import com.jeeproject.jeeProject.services.StatistiqueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatistiqueController {

    @Autowired
    private StatistiqueServiceImpl statistiqueService;
    @GetMapping("/sites")
    public ResponseEntity<Object> get5SiteWithMostSession() {
        try{
            List<Object[]> sites =statistiqueService.getSiteWithMostSession();
            return ResponseEntity.status(HttpStatus.OK).body(sites);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
