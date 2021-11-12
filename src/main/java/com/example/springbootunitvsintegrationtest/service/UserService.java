package com.example.springbootunitvsintegrationtest.service;

import com.example.springbootunitvsintegrationtest.dto.UserDTO;
import com.example.springbootunitvsintegrationtest.model.User;

import java.util.List;

public interface UserService {

    User createUser(UserDTO userDTO);
    User updateUser(int id,UserDTO userDTO);
    User getUser(int id);
    void deleteUser(int id);
    List<User> getUsers();

}
