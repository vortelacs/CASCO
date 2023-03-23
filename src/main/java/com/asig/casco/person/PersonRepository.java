package com.asig.casco.person;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface PersonRepository  extends JpaRepository<Person, Long>{

    Person findByFirstName(String firstName);

    Person findByEmail(String email);
    Person save(Person person);

}
