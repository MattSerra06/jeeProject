package com.jeeproject.jeeProject.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Session {
    @Column(unique = true)
    private String codeSession;
    private Date date;
    private String heureDebut;
    private String heureFin;
    @ManyToOne
    private Discipline discipline;
    @ManyToOne
    private Epreuve epreuve;
    @ManyToOne
    private Site siteCompetition;
    private String description;
    private String typeSession;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Constructeur par défaut
    public Session() {
    }

    // Constructeur avec paramètres
    public Session(String codeSession, Date date, String heureDebut, String heureFin,
                   Discipline discipline, Epreuve epreuve, Site siteCompetition,
                   String description, String typeSession) {
        this.codeSession = codeSession;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.discipline = discipline;
        this.epreuve = epreuve;
        this.siteCompetition = siteCompetition;
        this.description = description;
        this.typeSession = typeSession;
    }

    // Méthodes getters et setters pour accéder aux attributs
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

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
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

    // Méthode toString pour afficher les informations de la session
    @Override
    public String toString() {
        return "Session [codeSession=" + codeSession + ", date=" + date + ", heureDebut=" + heureDebut +
                ", heureFin=" + heureFin + ", discipline=" + discipline + ", epreuve=" + epreuve +
                ", siteCompetition=" + siteCompetition + ", description=" + description +
                ", typeSession=" + typeSession + "]";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
