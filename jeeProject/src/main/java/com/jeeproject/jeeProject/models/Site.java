package com.jeeproject.jeeProject.models;

import jakarta.persistence.*;

@Entity
public class Site {
    private String nom;
    private String ville;
    private CategorieSite category;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // Enumération pour les catégories de site
    public enum CategorieSite {//class à part
        STADE, SALLE_DE_SPECTACLE, LIEU_PUBLIC, CENTRE_AQUATIQUE
    }

    // Constructeur par défaut
    public Site() {
    }

    // Constructeur avec paramètres
    public Site(String nom, String ville, CategorieSite category) {
        this.nom = nom;
        this.ville = ville;
        this.category = category;
    }

    // Méthodes getters et setters pour accéder aux attributs
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public CategorieSite getCategory() {
        return category;
    }

    public void setCategory(CategorieSite category) {
        this.category = category;
    }

    // Méthode toString pour afficher les informations du site
    @Override
    public String toString() {
        return "Site [nom=" + nom + ", ville=" + ville + ", categorie=" + category + "]";
    }
}
