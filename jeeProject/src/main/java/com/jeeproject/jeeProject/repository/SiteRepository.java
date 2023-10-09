package com.jeeproject.jeeProject.repository;

import com.jeeproject.jeeProject.models.Site;
import org.springframework.data.repository.CrudRepository;

public interface SiteRepository extends CrudRepository<Site,Long> {

    boolean existsByNomAndVilleAndCategorie(String nom, String ville, Site.CategorieSite category);


}
