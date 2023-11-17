package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.resources.DisciplineResource;

import java.io.IOException;

public interface DisciplineService {
    public Iterable<DisciplineResource> getDisciplines();

    public DisciplineResource getDiscipline(Long id);

    public DisciplineResource createDiscipline(DisciplineResource disciplineResource) throws IOException;

    public DisciplineResource updateDiscipline(DisciplineResource disciplineResource, Long id);

    public void deleteDiscipline(Long id);

}
