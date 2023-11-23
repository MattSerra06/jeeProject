package com.jeeproject.jeeProject.repository;

import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.models.Epreuve;
import com.jeeproject.jeeProject.models.Session;
import com.jeeproject.jeeProject.models.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Long> {
    boolean existsByCodeSessionAndDateAndHeureDebutAndHeureFinAndDisciplineAndEpreuveAndSiteCompetitionAndDescriptionAndTypeSession(
            String codeSession, Date date, String heureDebut, String heureFin, Discipline discipline, Epreuve epreuve,
            Site siteCompetition, String description, String typeSession
    );

    @Query("SELECT s.siteCompetition, COUNT(s) as sessionCount FROM Session s GROUP BY s.siteCompetition ORDER BY sessionCount DESC")
    List<Object[]> findTop5SitesBySessionCount();

    boolean existsByDisciplineAndDateAndHeureDebutAndHeureFin(Discipline discipline,Date date,String heureDebut,String heureFin);

}
