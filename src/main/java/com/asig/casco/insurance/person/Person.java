package com.asig.casco.insurance.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

import javax.persistence.*;



import java.util.UUID;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Person {

    @Id
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phoneNumber;

    @Column
    private String idnp;


}
