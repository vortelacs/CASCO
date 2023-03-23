package com.asig.casco.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity(name="PERSON")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons", schema = "casco")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private String internID;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "phone")
    private String phoneNumber;
    @Column(name = "IDNP")
    private String IDNP;
    @Email
    @Column(name = "email")
    private String email;

}
