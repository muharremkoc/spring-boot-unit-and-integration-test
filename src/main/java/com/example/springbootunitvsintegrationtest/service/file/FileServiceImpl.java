package com.example.springbootunitvsintegrationtest.service.file;


import com.example.springbootunitvsintegrationtest.file.factory.FileInfo;
import com.example.springbootunitvsintegrationtest.file.mapper.FileMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class FileServiceImpl implements FileService{

    FileMapper fileMapper;

    @Override
    public FileInfo convertByte(MultipartFile file) throws IOException {

        FileInfo fileInfo=fileMapper.fileToFileInfo(file);

        return fileInfo;

    }

    @Override
    public String submit(MultipartFile[] files, ModelMap modelMap) {
        modelMap.addAttribute("files", files);
        return "fileUploadView";
    }


}
