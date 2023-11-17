package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.resources.SessionResource;

import java.io.IOException;

public interface SessionService {

    public Iterable<SessionResource> getSessions();
    public SessionResource getSession(Long id);

    public SessionResource createSession(SessionResource sessionResource) throws IOException;

    public SessionResource updateSession(SessionResource sessionResource,Long id);

    public void deleteSession(Long id);
}
