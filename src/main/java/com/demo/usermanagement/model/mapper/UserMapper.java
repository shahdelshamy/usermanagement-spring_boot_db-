package com.demo.usermanagement.model.mapper;

import com.demo.usermanagement.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import userDto.User;
import userDto.UserResponse;
import userDto.UserUpdate;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //Creating new user object based on userDto
    @Mapping(target = "id", ignore = true)
    UserEntity UserDtoMapToUser(User userDto);

    UserResponse userEntityMapToUserResponse(UserEntity user);

    //Update aer with valn existing usues from a UserDto object.
    //@Mapping(target = "fullName", ignore = true)
    //@Mapping(target = "gender", ignore = true)
    UserEntity UpdateDtoMapToUser(UserUpdate userUpdateDto, @MappingTarget UserEntity user);



}
