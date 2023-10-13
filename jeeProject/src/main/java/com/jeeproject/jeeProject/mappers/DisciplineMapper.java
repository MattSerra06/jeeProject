package com.jeeproject.jeeProject.mappers;

import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.resources.DisciplineResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface DisciplineMapper {
    DisciplineResource disciplineToDisciplineResource(Discipline discipline);

    @Mapping(target="id",ignore=true)
    Discipline disciplineResourceToDiscipline(DisciplineResource disciplineResource);

    void updateDisciplineFromResource(DisciplineResource disciplineResource, @MappingTarget Discipline discipline);
}
