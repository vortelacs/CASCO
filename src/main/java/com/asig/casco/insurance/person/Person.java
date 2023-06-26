package com.asig.casco.insurance.person;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import java.util.UUID;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Person {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    public Person(String firstName, String lastName, String phone, String idnp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.idnp = idnp;
    }

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phone;

    @Column
    private String idnp;


}
