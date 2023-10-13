package com.jeeproject.jeeProject.resources;

public class DisciplineResource {
    private String nom;
    private boolean estParalympique;
    private Long id;

    // Constructeur par défaut
    public DisciplineResource(){

    }

    // Constructeur avec paramètres
    public DisciplineResource(String nom, boolean estParalympique, Long id){
        this.nom = nom;
        this.estParalympique = estParalympique;
        this.id = id;
    }

    // Méthode qui affiche les informations de discipline
    @Override
    public String toString() {
        return "DisciplineRessource{" +
                "nom='" + nom + '\'' +
                ", estParalympique=" + estParalympique +
                ", id=" + id +
                '}';
    }

    // Getters and setters des éléments de discipline
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isEstParalympique() {
        return estParalympique;
    }

    public void setEstParalympique(boolean estParalympique) {
        this.estParalympique = estParalympique;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
