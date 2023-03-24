package com.example.demo.resource;

import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/bean")
@Slf4j
@Value
@NonFinal
public class BeanController implements BeanClassLoaderAware {

    ApplicationContext applicationContext;
    @NonFinal
    ClassLoader classLoader;

    public BeanController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("{name}")
    public @ResponseBody
    String getBeanByName(@PathVariable String name) {
        if(applicationContext.containsBean(name)) {
            return name;
        }
        return null;
    }

    @GetMapping
    public @ResponseBody
    String[] getBeans() {
        return applicationContext.getBeanDefinitionNames();
    }


    @GetMapping("classes")
    public @ResponseBody
    Stream<String> getBeanTypes() {
        return Arrays.stream(applicationContext.getBeanDefinitionNames()).map(name -> applicationContext.getType(name).getName());
    }

    @GetMapping("boot")
    public @ResponseBody
    boolean getBeanBoot() throws ClassNotFoundException {
        Class.forName("org.springframework.web.context.support.GenericWebApplicationContext", false, classLoader);
        return true;
    }


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}