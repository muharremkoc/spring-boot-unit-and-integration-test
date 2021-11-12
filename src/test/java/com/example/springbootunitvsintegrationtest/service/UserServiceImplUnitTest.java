package com.example.springbootunitvsintegrationtest.service;

import com.example.springbootunitvsintegrationtest.dto.UserDTO;
import com.example.springbootunitvsintegrationtest.mapper.UserMapper;
import com.example.springbootunitvsintegrationtest.model.User;
import com.example.springbootunitvsintegrationtest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

@SpringBootTest
@AutoConfigureMockMvc
class UserServiceImplUnitTest {

     @MockBean
     UserService userService;


     @MockBean
     UserMapper userMapper;
     @Test
     public void user_saved_and_is_return_true(){

         UserDTO userDTO= UserDTO.builder()
                 .firstName("Muharrem")
                 .lastName("Koc")
                 .build();

         User user= User.builder()
                 .id(1).build();


     Mockito.when(userService.createUser(userDTO)).thenReturn(user);


     User savedUser=userService.createUser(userDTO);

     assertNotNull(savedUser.getId());

     }

     @Test
     public void get_user_with_using_userId(){

          int id=2;

          User user= User.builder()
                  .id(1)
                  .firstName("Muharrem")
                  .build();


          Mockito.when(userService.getUser(user.getId())).thenReturn(user);

          assertEquals(id,user.getId());
     }

     @Test
     public void get_Users_is_Empty(){

          User user= User.builder()
                  .id(1)
                  .firstName("Can")
                  .lastName("Ozyigit")
                  .age(21)
                  .birthDay(new Date(07-11-2000))

                  .build();
          List<User> users=new ArrayList<>();

          users.add(user);

          Mockito.when(userService.getUsers()).thenReturn(users);

          assertFalse(users.isEmpty());

     }

     @Test
     public void user_updated_and_is_return_true() {

          int id=1;

          UserDTO userDTO = UserDTO.builder()
                  .firstName("Muharrem")
                  .lastName("Koc")
                  .build();

          User user= User.builder()
                  .id(id)
                  .firstName("Mahmut").build();
          Mockito.when(userService.updateUser(id,userDTO)).thenReturn(user);
          userDTO.setFirstName("Mahmuterrr");

          User updatedUser=userService.updateUser(id,userDTO);

          assertNotNull(updatedUser.getId());
     }



}