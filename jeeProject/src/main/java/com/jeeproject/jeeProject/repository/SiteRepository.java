package com.jeeproject.jeeProject.repository;

import com.jeeproject.jeeProject.models.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends CrudRepository<Site,Long> {

    boolean existsByNomAndVilleAndCategorie(String nom, String ville, Site.CategorieSite category);


}
