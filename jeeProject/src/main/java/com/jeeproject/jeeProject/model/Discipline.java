package com.jeeproject.jeeProject.model;

public class Discipline {
    private String nom;
    private boolean paralympique;

    // Constructeur par défaut
    public Discipline() {
    }

    // Constructeur avec paramètres
    public Discipline(String nom, boolean paralympique) {
        this.nom = nom;
        this.paralympique = paralympique;
    }

    // Méthodes getters et setters pour accéder aux attributs
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isParalympique() {
        return paralympique;
    }

    public void setParalympique(boolean paralympique) {
        this.paralympique = paralympique;
    }

    // Méthode toString pour afficher les informations de la discipline
    @Override
    public String toString() {
        return "Discipline [nom=" + nom + ", paralympique=" + paralympique + "]";
    }
}
