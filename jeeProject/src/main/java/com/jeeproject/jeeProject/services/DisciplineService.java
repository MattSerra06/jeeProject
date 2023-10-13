package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.resources.DisciplineResource;

import java.io.IOException;

public interface DisciplineService {
    public Iterable<Discipline> getDisciplines();

    public DisciplineResource createDiscipline(DisciplineResource disciplineResource) throws IOException;

    public DisciplineResource updateDiscipline(DisciplineResource disciplineResource, Long id);

    public void deleteDiscipline(Long id);

}
