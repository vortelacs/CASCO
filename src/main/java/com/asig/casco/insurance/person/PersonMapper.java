package com.asig.casco.insurance.person;

import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public Person toEntity(PersonDTO dto) {
        Person person = new Person();
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setIdnp(dto.getIdnp());
        person.setPhone(dto.getPhone());
        return person;
    }

    public PersonDTO toDTO(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setIdnp(person.getIdnp());
        dto.setPhone(person.getPhone());
        return dto;
    }
}