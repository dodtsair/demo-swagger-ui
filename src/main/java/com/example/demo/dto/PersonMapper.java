package com.example.demo.dto;


import com.example.demo.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper MAPPER = Mappers.getMapper(PersonMapper.class);

    static PersonDto map(Person person) {
        return MAPPER.convert(person);
    }

    static Person map(PersonDto person) {
        return MAPPER.convert(person);
    }

    @Mapping(source = "globalId", target = "id")
    PersonDto convert(Person person);
    @Mapping(source = "id", target = "globalId")
    @Mapping(target = "id", ignore = true)
    Person convert(PersonDto person);
}
