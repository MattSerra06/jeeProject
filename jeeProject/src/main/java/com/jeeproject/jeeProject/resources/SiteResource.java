package com.jeeproject.jeeProject.resources;

import com.jeeproject.jeeProject.models.Site;

public class SiteResource {
    private String nom;
    private String ville;
    private Site.CategorieSite categorie;
    private Long id;

    public SiteResource(String nom, String ville, Site.CategorieSite categorie) {
        this.nom = nom;
        this.ville = ville;
        this.categorie = categorie;
    }

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

    public Site.CategorieSite getCategorie() {
        return categorie;
    }

    public void setCategorie(Site.CategorieSite categorie) {
        this.categorie = categorie;
    }
}
