package com.example.springbootunitvsintegrationtest.file.mapper;


import com.example.springbootunitvsintegrationtest.file.factory.FileInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper
public interface FileMapper {

    @Mapping(source = "originalFilename", target = "name")
    @Mapping(source = "contentType", target = "type")
    @Mapping(source = "size", target = "size")
    @Mapping(source = "bytes", target = "data")
    FileInfo fileToFileInfo(MultipartFile file) throws IOException;

}
