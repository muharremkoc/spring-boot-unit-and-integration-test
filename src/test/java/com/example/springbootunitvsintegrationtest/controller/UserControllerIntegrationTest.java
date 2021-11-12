package com.example.springbootunitvsintegrationtest.controller;

import com.example.springbootunitvsintegrationtest.dto.UserDTO;
import com.example.springbootunitvsintegrationtest.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {


    @MockBean
    UserController userController;


    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void user_saved_integration() throws Exception {

        String firstName = "Muharrem";
        String lastName = "Koc";

        UserDTO userDTO = UserDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();

        User user = User.builder()
                .id(1).firstName(firstName).lastName(lastName).build();


        Mockito.when(userController.createUser(userDTO)).thenReturn(user);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/tests/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andReturn();

        User savedUser =
                objectMapper.readValue(mvcResult.getResponse().getContentAsString(), User.class);

        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals(1, savedUser.getId());
        assertEquals(200, mvcResult.getResponse().getStatus());
    }
    @Test
    public void user_updated_integration() throws Exception {

        int id=1;

        String firstName = "Muharrem";
        String lastName = "Koc";

        UserDTO userDTO = UserDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();

        User user = User.builder()
                .id(id).build();

        userDTO.setFirstName("Mahmuteeerrr");

        user.setFirstName(userDTO.getFirstName());

        Mockito.when(userController.updateUser(id,userDTO)).thenReturn(user);




        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/tests/user/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)

                        .content(objectMapper.writeValueAsString(userDTO)))
                .andReturn();

        User savedUser =
                objectMapper.readValue(mvcResult.getResponse().getContentAsString(), User.class);

        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals(1, savedUser.getId());
        assertEquals(201, mvcResult.getResponse().getStatus());
    }

}