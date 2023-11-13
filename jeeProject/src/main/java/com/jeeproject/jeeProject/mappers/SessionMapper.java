package com.jeeproject.jeeProject.mappers;

import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.models.Session;
import com.jeeproject.jeeProject.models.Site;
import com.jeeproject.jeeProject.resources.DisciplineResource;
import com.jeeproject.jeeProject.resources.SessionResource;
import com.jeeproject.jeeProject.resources.SiteResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface SessionMapper {

    @Mapping(target = "disciplineName",source="discipline.nom")
    @Mapping(target = "siteName",source="siteCompetition.nom")
    SessionResource sessionToSessionResource(Session session);

    @Mapping(target="id",ignore=true)
    @Mapping(target = "discipline",ignore = true)
    @Mapping(target = "siteCompetition",ignore = true)
    Session sessionResourceToSession(SessionResource sessionResource);

    void updateSessionFromResource(SessionResource sessionResource, @MappingTarget Session session);

}
