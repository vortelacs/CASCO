package com.asig.casco.insurance.person;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

@org.springframework.stereotype.Repository
public interface PersonRepository extends JpaRepository<Person, UUID>{

    Person findByFirstName(String firstName);

    Person save(Person person);

}
