package com.example.springbootunitvsintegrationtest.decorator;


import com.example.springbootunitvsintegrationtest.dto.UserDTO;
import com.example.springbootunitvsintegrationtest.mapper.UserMapper;
import com.example.springbootunitvsintegrationtest.model.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserMapperDecorator implements UserMapper {
    @Setter(onMethod = @__({@Autowired}))
    UserMapper userMapper;

    @Override
    public User userDTOtoUser(UserDTO userDTO) {
        User user=userMapper.userDTOtoUser(userDTO);
        Date date=new Date(System.currentTimeMillis());

        if(date.getYear()>=userDTO.getBirthDay().getYear())
            user.setAge(date.getYear()-userDTO.getBirthDay().getYear());
        return user;
    }
}
