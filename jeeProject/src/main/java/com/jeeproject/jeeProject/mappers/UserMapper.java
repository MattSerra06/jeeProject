package com.jeeproject.jeeProject.mappers;

import com.jeeproject.jeeProject.models.User;
import com.jeeproject.jeeProject.resources.UserResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface UserMapper {

    UserResource userToUserResource(User user);

    @Mapping(target = "id", ignore = true)
    User userResourceToUser(UserResource userResource);

    void updateUserFromResource(UserResource userResource, @MappingTarget User user);
}
