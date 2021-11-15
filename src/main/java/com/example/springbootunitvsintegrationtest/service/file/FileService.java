package com.example.springbootunitvsintegrationtest.service.file;


import com.example.springbootunitvsintegrationtest.file.factory.FileInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    FileInfo convertByte(MultipartFile file) throws IOException;

    String submit(MultipartFile[] files, ModelMap modelMap);


}
