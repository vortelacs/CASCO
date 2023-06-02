package com.asig.casco.insurance.person;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Person {

    @Id
    @GeneratedValue
    @Column
    private UUID ID;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phoneNumber;

    @Column
    private String IDNP;


}
