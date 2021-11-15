package com.example.springbootunitvsintegrationtest.service.user;

import com.example.springbootunitvsintegrationtest.dto.UserDTO;
import com.example.springbootunitvsintegrationtest.mapper.UserMapper;
import com.example.springbootunitvsintegrationtest.model.User;
import com.example.springbootunitvsintegrationtest.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    final UserRepository userRepository;

    final UserMapper userMapper;

    @Override
    public User createUser(UserDTO userDTO) {

       User user=userMapper.userDTOtoUser(userDTO);

        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, UserDTO userDTO) {
        User user=userRepository.findById(id).orElseThrow();




        Date date=new Date(System.currentTimeMillis());

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAge(date.getYear()-userDTO.getBirthDay().getYear());


        return userRepository.save(user);
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(int id) {
         userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
