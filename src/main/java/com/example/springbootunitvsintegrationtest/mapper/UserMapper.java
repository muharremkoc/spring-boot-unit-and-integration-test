package com.example.springbootunitvsintegrationtest.mapper;

import com.example.springbootunitvsintegrationtest.decorator.UserMapperDecorator;
import com.example.springbootunitvsintegrationtest.dto.UserDTO;
import com.example.springbootunitvsintegrationtest.model.User;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {


    @Mappings(
      {
        @Mapping(target = "firstName",source = "firstName"),
        @Mapping(target = "lastName",source = "lastName"),
        @Mapping(target = "birthDay",source = "birthDay")
      }
    )
    User userDTOtoUser(UserDTO userDTO);
}
