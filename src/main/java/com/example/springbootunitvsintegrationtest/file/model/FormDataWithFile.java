package com.example.springbootunitvsintegrationtest.file.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FormDataWithFile {

     String name;
     String email;
     MultipartFile file;
}
