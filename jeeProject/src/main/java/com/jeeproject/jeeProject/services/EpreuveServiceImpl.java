package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.mappers.EpreuveMapper;
import com.jeeproject.jeeProject.models.Discipline;
import com.jeeproject.jeeProject.models.Epreuve;
import com.jeeproject.jeeProject.repository.DisciplineRepository;
import com.jeeproject.jeeProject.repository.EpreuveRepository;
import com.jeeproject.jeeProject.resources.EpreuveResource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EpreuveServiceImpl implements EpreuveService{

    @Autowired
    private EpreuveRepository epreuveRepository;
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private EpreuveMapper epreuveMapper;

    @Override
    public Iterable<EpreuveResource> getEpreuves(){
        Iterable<Epreuve> epreuves = epreuveRepository.findAll();
        return StreamSupport.stream(epreuves.spliterator(), false)
                .map(epreuveMapper::epreuveToEpreuveResource)
                .collect(Collectors.toList());
    }

    @Override
    public EpreuveResource getEpreuve(Long id) {
        Epreuve epreuve = epreuveRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No epreuve found in db with the id :"+id));
        return epreuveMapper.epreuveToEpreuveResource(epreuve);
    }

    @Override
    public EpreuveResource createEpreuve(EpreuveResource epreuveResource) throws Exception {
        if(!estEnDB(epreuveResource)){
            Epreuve epreuve = epreuveMapper.epreuveResourceToEpreuve(epreuveResource);
            epreuve.setDiscipline(disciplineRepository.findByNom(epreuveResource.getDisciplineNom()));
            epreuveRepository.save(epreuve);
            return epreuveMapper.epreuveToEpreuveResource(epreuve);
        }
        else{
            throw new Exception("Epreuve déjà présente en DB");
        }
    }

    @Override
    public EpreuveResource updateEpreuve(EpreuveResource epreuveResource, Long id) {
        Epreuve epreuve = epreuveRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No epreuve found in db with the id :"+id));
        epreuveMapper.updateEpreuveFromResource(epreuveResource,epreuve);
        epreuveRepository.save(epreuve);
        return  epreuveMapper.epreuveToEpreuveResource(epreuve);
    }

    @Override
    public void deleteEpreuve(Long id) {
        epreuveRepository.deleteById(id);
    }

    @Override
    public Iterable<EpreuveResource> getAllEpreuvesByDiscipline(){
        Iterable<Epreuve> epreuves = epreuveRepository.findAllEpreuvesOrderByDiscipline();
        return StreamSupport.stream(epreuves.spliterator(), false)
                .map(epreuveMapper::epreuveToEpreuveResource)
                .collect(Collectors.toList());
    }
    public Iterable<EpreuveResource> getEpreuvesByDiscipline(String disciplineName){
        Iterable<Epreuve> epreuves = epreuveRepository.findEpreuvesByDisciplineNom(disciplineName);
        return StreamSupport.stream(epreuves.spliterator(), false)
                .map(epreuveMapper::epreuveToEpreuveResource)
                .collect(Collectors.toList());
    }
    public boolean estEnDB(EpreuveResource epreuveResource){
        return epreuveRepository.existsByNomAndDiscipline(epreuveResource.getNom(),disciplineRepository.findByNom(epreuveResource.getDisciplineNom()));
    }
}
