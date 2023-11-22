package com.jeeproject.jeeProject.repository;

import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.models.Epreuve;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EpreuveRepository extends CrudRepository<Epreuve,Long> {
    boolean existsByNomAndDiscipline(String nom, Discipline discipline);
    @Query("SELECT e FROM Epreuve e JOIN e.discipline d ORDER BY d.nom")
    Iterable<Epreuve> findAllEpreuvesOrderByDiscipline();

    Epreuve findByNom(String nom);

    @Query("SELECT e FROM Epreuve e WHERE e.discipline.nom = :nomDiscipline")
    Iterable<Epreuve> findEpreuvesByDisciplineNom(@Param("nomDiscipline") String nomDiscipline);

}
