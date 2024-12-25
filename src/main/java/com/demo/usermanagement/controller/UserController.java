package com.demo.usermanagement.controller;


import api.*;
import com.demo.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import userDto.User;
import userDto.UserResponse;
import userDto.UserUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController implements AddUserApi, DeleteUserApi, UpdateUserApi, GetAllUsersApi, GetUserByIdApi {

    @Autowired
    private UserService userService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return AddUserApi.super.getRequest();
    }

    @Override
    public ResponseEntity<UserResponse> registerUser(User user) {
        //return AddUserApi.super.registerUser(user);
        return ResponseEntity.ok(userService.addUser(user));
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(UserUpdate userUpdate) {
        //return UpdateUserApi.super.updateUser(userUpdate);
        return ResponseEntity.ok(userService.updateUser(userUpdate));
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<String> deleteUser(Integer id) {
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

}
