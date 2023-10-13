package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.mappers.DisciplineMapper;
import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.repository.DisciplineRepository;
import com.jeeproject.jeeProject.resources.DisciplineResource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class DisciplineServiceImpl implements DisciplineService{
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private DisciplineMapper disciplineMapper;
    @Override
    public Iterable<Discipline> getDisciplines() {
        return disciplineRepository.findAll();
    }

    public DisciplineResource createDiscipline(DisciplineResource disciplineResource) throws IOException{
        Discipline discipline = disciplineMapper.disciplineResourceToDiscipline(disciplineResource);
        if(!estEnDB(disciplineResource)){
            disciplineRepository.save(discipline);
        }else{
            throw new IOException("Discipline déjà présente en DB");
        }
        return disciplineMapper.disciplineToDisciplineResource(discipline);
    }

    public DisciplineResource updateDiscipline(DisciplineResource disciplineResource, Long id){
        Discipline discipline = disciplineRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Discipline not found with id :"+id));
        disciplineMapper.updateDisciplineFromResource(disciplineResource,discipline);
        disciplineRepository.save(discipline);
        return disciplineMapper.disciplineToDisciplineResource(discipline);
    }

    public void deleteDiscipline(Long id){disciplineRepository.deleteById(id);}

    private boolean estEnDB(DisciplineResource disciplineResource){
        return disciplineRepository.existsByNomAndEstParalympique(disciplineResource.getNom(), disciplineResource.isEstParalympique());
    }

}
