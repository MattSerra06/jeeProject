package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.mappers.DisciplineMapper;
import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.models.Epreuve;
import com.jeeproject.jeeProject.repository.DisciplineRepository;
import com.jeeproject.jeeProject.resources.DisciplineResource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DisciplineServiceImpl implements DisciplineService{
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private DisciplineMapper disciplineMapper;
    @Override
    public Iterable<DisciplineResource> getDisciplines() {
        Iterable<Discipline> disciplines = disciplineRepository.findAll();
        return StreamSupport.stream(disciplines.spliterator(), false)
                .map(disciplineMapper::disciplineToDisciplineResource)
                .collect(Collectors.toList());
    }

    public DisciplineResource getDiscipline(Long id){
        Discipline discipline = disciplineRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No Discipline found in db with the id :"+id));;
        return disciplineMapper.disciplineToDisciplineResource(discipline);
    }

    @Override
    public DisciplineResource createDiscipline(DisciplineResource disciplineResource) throws IOException{
        Discipline discipline = disciplineMapper.disciplineResourceToDiscipline(disciplineResource);
        if(!estEnDB(disciplineResource)){
            disciplineRepository.save(discipline);
        }else{
            throw new IOException("Discipline déjà présente en DB");
        }
        return disciplineMapper.disciplineToDisciplineResource(discipline);
    }
    @Override
    public DisciplineResource updateDiscipline(DisciplineResource disciplineResource, Long id){
        Discipline discipline = disciplineRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Discipline not found with id :"+id));
        disciplineMapper.updateDisciplineFromResource(disciplineResource,discipline);
        disciplineRepository.save(discipline);
        return disciplineMapper.disciplineToDisciplineResource(discipline);
    }
    @Override
    public void deleteDiscipline(Long id){disciplineRepository.deleteById(id);}

    private boolean estEnDB(DisciplineResource disciplineResource){
        return disciplineRepository.existsByNomAndEstParalympique(disciplineResource.getNom(), disciplineResource.isEstParalympique());
    }

}
