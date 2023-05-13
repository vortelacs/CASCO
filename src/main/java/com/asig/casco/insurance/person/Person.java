package com.asig.casco.insurance.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity(name="PERSON")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person", schema = "casco")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID internID;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "phone")
    private String phoneNumber;
    @Column(name = "IDNP")
    private String IDNP;


}
