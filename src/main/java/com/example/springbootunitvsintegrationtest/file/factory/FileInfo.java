package com.example.springbootunitvsintegrationtest.file.factory;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileInfo {

    String id;
    String name;
    String type;
    Long size;
    byte[] data;
}
