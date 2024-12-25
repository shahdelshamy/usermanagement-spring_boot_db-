package com.demo.usermanagement.service;

import com.demo.usermanagement.model.entity.UserEntity;
import com.demo.usermanagement.model.mapper.UserMapper;
import com.demo.usermanagement.repositorty.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userDto.User;
import userDto.UserResponse;
import userDto.UserUpdate;

import java.util.List;

@Service
public class UserServiceImp  implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserResponse addUser(User userDto) {
            //persist()->for insert only but save for insert and update
         UserEntity user= userRepo.save(mapper.UserDtoMapToUser(userDto));
         System.out.println(user.getEmail());
        return mapper.userEntityMapToUserResponse(user);
    }

    @Override
    public UserResponse updateUser(UserUpdate userDto) {
        UserEntity user=  userRepo.findById(userDto.getId()).get();
        UserEntity userEntity= userRepo.save(mapper.UpdateDtoMapToUser(userDto,user));
        return mapper.userEntityMapToUserResponse(userEntity);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepo.findAll().stream().map((userEntity)->mapper.userEntityMapToUserResponse(userEntity)).toList();
    }

    @Override
    public UserResponse getUserById(Integer id) {
        UserEntity userEntity= userRepo.findById(id).orElseThrow(()->new RuntimeException("this user not found"));
        return mapper.userEntityMapToUserResponse(userEntity);
    }

    @Override
    public String deleteUserById(Integer id) {
         userRepo.deleteById(id);
        return "deleting is successfully";
    }
}
