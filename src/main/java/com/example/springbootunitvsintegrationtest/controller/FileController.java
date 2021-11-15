package com.example.springbootunitvsintegrationtest.controller;


import com.example.springbootunitvsintegrationtest.file.factory.FileInfo;
import com.example.springbootunitvsintegrationtest.service.file.FileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping(value = "/files/test/")
public class FileController {


    FileService fileService;

    @PostMapping(value = "/uploadFile",consumes = "multipart/form-data")
    public ResponseEntity<Object> fileUpload(@RequestPart("file") MultipartFile file,ModelMap modelMap) throws IOException{
        modelMap.addAttribute("file",file);
        return new ResponseEntity<Object>("The File Uploaded Successfully", HttpStatus.OK);
    }



   @PostMapping(value = "/multiFile",consumes = "multipart/form-data")
    public String submit(@RequestPart("files") MultipartFile[] files, ModelMap modelMap) {
        return fileService.submit(files, modelMap);
    }


       @PostMapping(value = "/getFileByte",consumes = { "multipart/form-data" })
       public FileInfo fileEdit(@RequestPart MultipartFile file) throws IOException {
           return fileService.convertByte(file);
       }



}
