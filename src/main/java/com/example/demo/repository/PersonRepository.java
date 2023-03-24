package com.example.demo.repository;

import com.example.demo.entity.Person;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@Service
@Slf4j
@NonFinal
@Value
@FieldDefaults(level = PRIVATE)
public class PersonRepository {

    Map<String, Person> persons = new HashMap<>();

    public Person addPerson(Person person) {
        person.setId(persons.size() + 1);
        persons.put(person.getGlobalId(), person);
        return person;
    }

    public Person getPerson(String id) {
        return persons.get(id);
    }

    public void deletePerson(String id) {
        persons.remove(id);
    }

    public Person updatePerson(String id, Person person) {
        persons.put(id, person);
        return person;
    }
}