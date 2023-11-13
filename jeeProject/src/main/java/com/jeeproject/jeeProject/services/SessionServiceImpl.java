package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.mappers.SessionMapper;
import com.jeeproject.jeeProject.repository.SessionRepository;
import com.jeeproject.jeeProject.models.Session;
import com.jeeproject.jeeProject.resources.SessionResource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class SessionServiceImpl implements SessionService{
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private SessionMapper sessionMapper;

    @Override
    public SessionResource getSession(Long id) {
        Session session = sessionRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No session found in db with the id :"+id));
        return sessionMapper.sessionToSessionResource(session);
    }

    @Override
    public SessionResource createSession(SessionResource sessionResource) throws IOException {
        if(!estEnDB(sessionResource)){
            Session session = sessionMapper.sessionResourceToSession(sessionResource);
            session.setDiscipline(sessionRepository.);
            sessionRepository.save(session);
            return sessionMapper.sessionToSessionResource(session);
        }else{
            throw new IOException("Site déjà présent en DB");
        }
    }

    @Override
    public SessionResource updateSession(SessionResource sessionResource,Long id) {
        Session session = sessionRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No session found in db with the id :"+id));
        sessionMapper.updateSessionFromResource(sessionResource,session);
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
                sessionResource.getDiscipline(), sessionResource.getEpreuve(), sessionResource.getSiteCompetition(), sessionResource.getDescription(),
                sessionResource.getTypeSession()
        );
    }
}
