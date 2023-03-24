package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Value;
import lombok.With;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@AllArgsConstructor
@With
@FieldDefaults(level = PRIVATE)
public class LogDto {

    @Generated
    public enum Level {
        ALL, TRACE, DEBUG, INFO, WARN, ERROR, OFF
    }

    String name;
    Level level;
}