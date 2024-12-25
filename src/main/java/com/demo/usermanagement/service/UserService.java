package com.demo.usermanagement.service;

import com.demo.usermanagement.model.entity.UserEntity;
import org.springframework.stereotype.Service;
import userDto.User;
import userDto.UserResponse;
import userDto.UserUpdate;

import java.util.List;


public interface UserService {

    public UserResponse addUser(User userDto);

    public UserResponse updateUser(UserUpdate userDto);

    public List<UserResponse> getAllUsers();

    public UserResponse getUserById(Integer id);

    public String deleteUserById(Integer id);



}
