package com.jeeproject.jeeProject.resources;

import java.util.Date;

public class SessionResource {
    private String codeSession;
    private Date date;
    private String heureDebut;
    private String heureFin;
    private String disciplineName;
    private String epreuveName;
    private String siteName;
    private String description;
    private String typeSession;
    private Long id;

    public SessionResource() {
    }

    public SessionResource(String codeSession, Date date, String heureDebut, String heureFin, String disciplineName, String epreuveName, String siteName, String description, String typeSession, Long id) {
        this.codeSession = codeSession;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.disciplineName = disciplineName;
        this.epreuveName = epreuveName;
        this.siteName = siteName;
        this.description = description;
        this.typeSession = typeSession;
        this.id = id;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
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

    public String getEpreuveName() {
        return epreuveName;
    }

    public void setEpreuveName(String epreuveName) {
        this.epreuveName = epreuveName;
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
