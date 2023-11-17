package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.resources.EpreuveResource;

public interface EpreuveService {

    public EpreuveResource getEpreuve(Long id);

    public EpreuveResource createEpreuve(EpreuveResource epreuveResource) throws Exception;

    public EpreuveResource updateEpreuve(EpreuveResource epreuveResource,Long id);

    public void deleteEpreuve(Long id);
}
