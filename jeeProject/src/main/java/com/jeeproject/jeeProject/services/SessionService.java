package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.resources.SessionResource;

import java.io.IOException;

public interface SessionService {
    public SessionResource getSession(Long id);

    public SessionResource createSession(SessionResource sessionResource) throws IOException;
}
