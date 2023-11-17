package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.resources.EpreuveResource;

import java.util.List;

public interface EpreuveService {

    public Iterable<EpreuveResource> getEpreuves();

    public EpreuveResource getEpreuve(Long id);

    public EpreuveResource createEpreuve(EpreuveResource epreuveResource) throws Exception;

    public EpreuveResource updateEpreuve(EpreuveResource epreuveResource,Long id);

    public void deleteEpreuve(Long id);
}
