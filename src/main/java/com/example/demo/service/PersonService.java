package com.example.demo.service;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.example.demo.dto.PersonMapper.map;

@Service
@Slf4j
@Value
@NonFinal
public class PersonService {

    PersonRepository personRepository;
    
    public PersonDto getPerson(String id) {

        return map(personRepository.getPerson(id));
    }

    public PersonDto createPerson(PersonDto personDto) {
        Person person = map(personDto);
        person.setGlobalId(UUID.randomUUID().toString());
        return map(personRepository.addPerson(person));
    }

    public void deletePerson(String personId) {
        personRepository.deletePerson(personId);
    }

    public PersonDto updatePerson(String id, PersonDto personDto) {
        Person person = map(personDto);
        person.setGlobalId(id);
        return map(personRepository.updatePerson(id, person));
    }

}