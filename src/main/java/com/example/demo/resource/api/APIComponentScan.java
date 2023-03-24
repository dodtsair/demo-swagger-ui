package com.example.demo.resource.api;

import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Value
@NonFinal
@ComponentScan
@EnableWebMvc
public class APIComponentScan {
}
