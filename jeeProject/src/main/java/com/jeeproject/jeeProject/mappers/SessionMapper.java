package com.jeeproject.jeeProject.mappers;

import com.jeeproject.jeeProject.models.Session;
import com.jeeproject.jeeProject.models.Site;
import com.jeeproject.jeeProject.resources.SessionResource;
import com.jeeproject.jeeProject.resources.SiteResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface SessionMapper {

    SessionResource sessionToSessionResource(Session session);

    @Mapping(target="id",ignore=true)
    Session sessionResourceToSession(SessionResource sessionResource);
}
