package com.asig.casco.person;

@org.springframework.stereotype.Repository
public interface PersonRepository {

    Person findByFirstName(String firstName);
    Person findById(Long id);
    Person findByEmail(String email);
    Person save(Person person);

    Person deleteById(Long id);
}
