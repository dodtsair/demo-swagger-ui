package com.example.demo.internal;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * With the separate dispatcherservlet we load beans into a different context
 */
@Configuration
@Value
@NonFinal
@ComponentScan
@EnableWebMvc
@ConfigurationPropertiesScan
@EqualsAndHashCode(callSuper = false)
public class InternalComponentScan {
}
