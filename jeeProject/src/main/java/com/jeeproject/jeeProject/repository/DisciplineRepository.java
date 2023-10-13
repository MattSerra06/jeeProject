package com.jeeproject.jeeProject.repository;

import com.jeeproject.jeeProject.models.Discipline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends CrudRepository<Discipline,Long> {
    
    boolean existsByNomAndEstParalympique(String nom, boolean estParalympique);
    
}
