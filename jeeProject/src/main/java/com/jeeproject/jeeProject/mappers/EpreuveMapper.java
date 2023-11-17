package com.jeeproject.jeeProject.mappers;

import com.jeeproject.jeeProject.models.Epreuve;
import com.jeeproject.jeeProject.models.Session;
import com.jeeproject.jeeProject.resources.EpreuveResource;
import com.jeeproject.jeeProject.resources.SessionResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface EpreuveMapper {
    @Mapping(target = "disciplineNom",source="discipline.nom")
    EpreuveResource epreuveToEpreuveResource(Epreuve epreuve);

    @Mapping(target="id",ignore=true)
    @Mapping(target = "discipline",ignore = true)
    Epreuve epreuveResourceToEpreuve(EpreuveResource epreuveResource);

    void updateEpreuveFromResource(EpreuveResource epreuveResource, @MappingTarget Epreuve epreuve);
}
