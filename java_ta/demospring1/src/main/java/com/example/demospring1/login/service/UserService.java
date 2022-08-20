package com.example.demospring1.login.service;


import com.example.demospring1.login.model.dto.user.UserCreateRequest;
import com.example.demospring1.login.model.enity.User;
import com.example.demospring1.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAllUser(){
        return userRepository.findAllUser();
    }
    public User findById(Integer id){
        return userRepository.findById(id);
    }
    public User findUser(String username, String password){
        return userRepository.findUser(username , password);
    }
    public User insertNewUser(String username, String password){
        return userRepository.insertNewUser(username, password);
    }
    public int createUser(UserCreateRequest userCreateRequest){
        return userRepository.saveUser(User.builder()
                .username(userCreateRequest.getUsername())
//                .firstname(userRegistration.getFirstName())
//                .lastname(userRegistration.getLastName())
                .password(userCreateRequest.getPassword())
                .build());
    }
}
