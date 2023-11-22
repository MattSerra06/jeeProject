package com.jeeproject.jeeProject.mappers;

import com.jeeproject.jeeProject.models.Site;
import com.jeeproject.jeeProject.resources.SiteResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface SiteMapper {
    SiteResource siteToSiteResource(Site site);

    @Mapping(target="id",ignore=true)
    Site siteResourceToSite(SiteResource siteResource);
    @Mapping(target="id",ignore=true)
    void updateSiteFromResource(SiteResource siteResource, @MappingTarget Site site);
}
