package com.jeeproject.jeeProject.models;

import jakarta.persistence.*;

@Entity
public class Discipline {
    @Column(name = "nom")
    private String nom;
    @Column(name="estParalympique",columnDefinition = "BOOLEAN")
    private boolean estParalympique;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Constructeur par défaut
    public Discipline() {
    }

    // Constructeur avec paramètres
    public Discipline(String nom, boolean estParalympique) {
        this.nom = nom;
        this.estParalympique = estParalympique;
    }

    // Méthodes getters et setters pour accéder aux attributs
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

    // Méthode toString pour afficher les informations de la discipline
    @Override
    public String toString() {
        return "Discipline [nom=" + nom + ", paralympique=" + estParalympique + "]";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
