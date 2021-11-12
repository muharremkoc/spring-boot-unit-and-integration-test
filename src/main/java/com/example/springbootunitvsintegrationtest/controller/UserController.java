package com.example.springbootunitvsintegrationtest.controller;

import com.example.springbootunitvsintegrationtest.dto.UserDTO;
import com.example.springbootunitvsintegrationtest.model.User;
import com.example.springbootunitvsintegrationtest.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/tests")
public class UserController {

     final UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }
   @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id")int id,@RequestBody UserDTO userDTO){
        return userService.updateUser(id,userDTO);
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id")int id){
        return userService.getUser(id);
    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id")int id){
         userService.deleteUser(id);
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
