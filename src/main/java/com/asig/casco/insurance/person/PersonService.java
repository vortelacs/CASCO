package com.asig.casco.insurance.person;

import com.asig.casco.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Person getPersonById(UUID id) throws ResourceNotFoundException{
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(UUID id, Person person) throws ResourceNotFoundException {
        Person existingPerson = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));
        existingPerson.setFirstName(person.getFirstName());
        return personRepository.save(existingPerson);
    }

    public void deletePerson(UUID id) {
        personRepository.deleteById(id);
    }
}
