package com.example.demo.internal.service;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.example.demo.dto.LogDto;
import lombok.Value;
import lombok.With;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@Slf4j
@Value
@With
@NonFinal
public class LogService {

    Function<String, org.slf4j.Logger> loggerFactory;

    public LogService() {
        loggerFactory = LoggerFactory::getLogger;
    }

    public LogService(Function<String, org.slf4j.Logger> loggerFactory) {
        this.loggerFactory = loggerFactory;
    }

    public LogDto getLog(String name) {
        log.debug("getLog for: {} ", name);
        var logger = loggerFactory.apply(name);

        if(logger instanceof Logger logback) {
            return new LogDto(name, LogDto.Level.valueOf(logback.getEffectiveLevel().toString()));
        }
        return new LogDto(name, null);
    }

    public LogDto setLevel(String name, LogDto logDto) {
        log.debug("setLog for: {} at {}", name, logDto.getLevel());
        var logger = loggerFactory.apply(name);
        if(logDto.getLevel() != null) {
            Level level = Level.valueOf(logDto.getLevel().name());
            if(logger instanceof Logger logback) {
                logback.setLevel(level);
                return logDto.withName(name);
            }
        }
        return logDto.withName(name).withLevel(null);
    }

    /**
     * @param name name of the SLF4J logger to be reset to parent
     */
    public void resetLog(String name) {
        log.debug("reset log for: {}", name);
        var logger = loggerFactory.apply(name);
        if(logger instanceof Logger logback) {
            logback.setLevel(null);
        }
    }
}