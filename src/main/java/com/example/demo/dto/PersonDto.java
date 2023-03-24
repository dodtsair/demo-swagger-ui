package com.example.demo.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class PersonDto implements Serializable {
    String id;
    String firstName;
    String lastName;
}