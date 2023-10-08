package com.jeeproject.jeeProject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Site {
    private String nom;
    private String ville;
    private CategorieSite categorie;
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
    public Site(String nom, String ville, CategorieSite categorie) {
        this.nom = nom;
        this.ville = ville;
        this.categorie = categorie;
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

    public CategorieSite getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieSite categorie) {
        this.categorie = categorie;
    }

    // Méthode toString pour afficher les informations du site
    @Override
    public String toString() {
        return "Site [nom=" + nom + ", ville=" + ville + ", categorie=" + categorie + "]";
    }
}
