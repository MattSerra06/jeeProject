package com.jeeproject.jeeProject.repository;

import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.models.Epreuve;
import org.springframework.data.repository.CrudRepository;

public interface EpreuveRepository extends CrudRepository<Epreuve,Long> {
    boolean existByNomAndDiscipline(String nom, Discipline discipline);
}
