package com.jeeproject.jeeProject.resources;

public class EpreuveResource {
    private Long id;
    private String nom;
    private String disciplineNom;

    public EpreuveResource() {
    }

    public EpreuveResource(Long id, String nom, String disciplineNom) {
        this.id = id;
        this.nom = nom;
        this.disciplineNom = disciplineNom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDisciplineNom() {
        return disciplineNom;
    }

    public void setDisciplineNom(String disciplineNom) {
        this.disciplineNom = disciplineNom;
    }
}
