package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.mappers.SessionMapper;
import com.jeeproject.jeeProject.repository.DisciplineRepository;
import com.jeeproject.jeeProject.repository.EpreuveRepository;
import com.jeeproject.jeeProject.repository.SessionRepository;
import com.jeeproject.jeeProject.models.Session;
import com.jeeproject.jeeProject.repository.SiteRepository;
import com.jeeproject.jeeProject.resources.SessionResource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private EpreuveRepository epreuveRepository;
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private SessionMapper sessionMapper;

    @Override
    public SessionResource getSession(Long id) {
        Session session = sessionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No session found in db with the id :" + id));
        return sessionMapper.sessionToSessionResource(session);
    }

    @Override
    public Iterable<SessionResource> getSessions() {
        Iterable<Session> sessions = sessionRepository.findAll();
        return StreamSupport.stream(sessions.spliterator(), false)
                .map(sessionMapper::sessionToSessionResource)
                .collect(Collectors.toList());
    }

    @Override
    public SessionResource createSession(SessionResource sessionResource) throws IOException {
        if (!estEnDB(sessionResource)) {
            if (sessionRepository.existsByDisciplineAndDateAndHeureDebutAndHeureFin(disciplineRepository.findByNom(sessionResource.getDisciplineName()), sessionResource.getDate(), sessionResource.getHeureDebut(), sessionResource.getHeureFin())) {
                throw new IOException("Il y a déjà une session sur ce créneau horaire.");
            }
            Session session = sessionMapper.sessionResourceToSession(sessionResource);
            session.setDiscipline(disciplineRepository.findByNom(sessionResource.getDisciplineName()));
            session.setSiteCompetition(siteRepository.findByNom(sessionResource.getSiteName()));
            session.setEpreuve(epreuveRepository.findByNom(sessionResource.getEpreuveName()));
            sessionRepository.save(session);
            return sessionMapper.sessionToSessionResource(session);
        } else {
            throw new IOException("Site déjà présent en DB");
        }
    }

    @Override
    public SessionResource updateSession(SessionResource sessionResource, Long id) {
        Session session = sessionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No session found in db with the id :" + id));
        sessionMapper.updateSessionFromResource(sessionResource, session);
        sessionRepository.save(session);
        return sessionMapper.sessionToSessionResource(session);
    }

    @Override
    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }


    public boolean estEnDB(SessionResource sessionResource) {
        return sessionRepository.existsByCodeSessionAndDateAndHeureDebutAndHeureFinAndDisciplineAndEpreuveAndSiteCompetitionAndDescriptionAndTypeSession(
                sessionResource.getCodeSession(), sessionResource.getDate(), sessionResource.getHeureDebut(), sessionResource.getHeureFin(),
                disciplineRepository.findByNom(sessionResource.getDisciplineName()), epreuveRepository.findByNom(sessionResource.getEpreuveName()), siteRepository.findByNom(sessionResource.getSiteName()), sessionResource.getDescription(),
                sessionResource.getTypeSession()
        );
    }

}
