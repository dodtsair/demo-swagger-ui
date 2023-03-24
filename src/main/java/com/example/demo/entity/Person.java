package com.example.demo.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class Person implements Serializable {

    Integer id;
    String globalId = UUID.randomUUID().toString();
    String firstName;
    String lastName;
}