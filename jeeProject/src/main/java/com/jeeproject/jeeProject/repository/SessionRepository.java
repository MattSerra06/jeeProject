package com.jeeproject.jeeProject.repository;

import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.models.Session;
import com.jeeproject.jeeProject.models.Site;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface SessionRepository extends CrudRepository<Session, Long> {
    boolean existsByCodeSessionAndDateAndHeureDebutAndHeureFinAndDisciplineAndEpreuveAndSiteCompetitionAndDescriptionAndTypeSession(
            String codeSession, Date date, String heureDebut, String heureFin, Discipline discipline, String epreuve,
            Site siteCompetition, String description, String typeSession
    );

}
