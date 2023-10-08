package com.jeeproject.jeeProject.mappers;

import org.mapstruct.ReportingPolicy;


@org.mapstruct.MapperConfig(componentModel = "spring", // Spécifiez le conteneur IoC Spring
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperConfig {
}
