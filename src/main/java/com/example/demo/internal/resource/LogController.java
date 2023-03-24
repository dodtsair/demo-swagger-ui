package com.example.demo.internal.resource;

import com.example.demo.dto.LogDto;
import com.example.demo.internal.service.LogService;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/log")
@Service
@Slf4j
@Value
@NonFinal
public class LogController {

    LogService logService;

    @GetMapping("{name}")
    public @ResponseBody
    LogDto getLevel(@PathVariable String name) {
        return logService.getLog(name);
    }

    @PutMapping("{name}")
    public LogDto setLevel(@PathVariable String name, @RequestBody LogDto logDto) {
        return logService.setLevel(name, logDto);
    }

    @DeleteMapping("{name}")
    public void resetLevel(@PathVariable String name) {
        logService.resetLog(name);
    }
}