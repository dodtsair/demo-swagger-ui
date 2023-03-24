package com.example.demo.resource.api;

import com.example.demo.dto.PersonDto;
import com.example.demo.service.PersonService;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
@Service
@Slf4j
@Value
@NonFinal
public class PersonController {

    public static final String PERSON_ID = "person.id";
    PersonService personService;

    @GetMapping("{id}")
    public @ResponseBody
    PersonDto getPerson(@PathVariable String id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto person) {
        return personService.createPerson(person);
    }

    @PutMapping("{id}")
    public PersonDto updatePerson(@PathVariable String id, @RequestBody PersonDto person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
    }
}