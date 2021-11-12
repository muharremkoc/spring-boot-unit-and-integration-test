package com.example.springbootunitvsintegrationtest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    String firstName;

    String lastName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    Date birthDay;
}
