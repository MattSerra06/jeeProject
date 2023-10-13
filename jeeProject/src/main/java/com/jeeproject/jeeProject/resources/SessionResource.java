package com.jeeproject.jeeProject.resources;

import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.models.Site;
import jakarta.persistence.*;

import java.util.Date;

public class SessionResource {
    private String codeSession;
    private Date date;
    private String heureDebut;
    private String heureFin;
    private Discipline discipline;
    private String epreuve;
    private Site siteCompetition;
    private String description;
    private String typeSession;
    private Long id;

    public SessionResource() {
    }

    public SessionResource(String codeSession, Date date, String heureDebut, String heureFin, Discipline discipline, String epreuve, Site siteCompetition, String description, String typeSession, Long id) {
        this.codeSession = codeSession;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.discipline = discipline;
        this.epreuve = epreuve;
        this.siteCompetition = siteCompetition;
        this.description = description;
        this.typeSession = typeSession;
        this.id = id;
    }

    public String getCodeSession() {
        return codeSession;
    }

    public void setCodeSession(String codeSession) {
        this.codeSession = codeSession;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public String getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(String epreuve) {
        this.epreuve = epreuve;
    }

    public Site getSiteCompetition() {
        return siteCompetition;
    }

    public void setSiteCompetition(Site siteCompetition) {
        this.siteCompetition = siteCompetition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeSession() {
        return typeSession;
    }

    public void setTypeSession(String typeSession) {
        this.typeSession = typeSession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
