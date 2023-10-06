package com.jeeproject.jeeProject.model;

public class Site {
    private String nom;
    private String ville;
    private CategorieSite categorie;

    // Enumération pour les catégories de site
    public enum CategorieSite {
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
