package com.example.springbootunitvsintegrationtest.controller;

import com.example.springbootunitvsintegrationtest.service.file.FileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
class FileControllerIntegrationTest
{

    @MockBean
    FileController fileController;

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;


    @BeforeEach
    public void setUp(){
        mockMvc = webAppContextSetup(webApplicationContext).build();

    }
    @Test
    public void added_file_is_not_null() throws Exception {


         InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.png");
         MockMultipartFile file = new MockMultipartFile("file", "test.png", "image/png", inputStream);




        mockMvc.perform(multipart("/files/test/getFileByte").file(file))
                .andExpect(status().isOk());
     }
    }
