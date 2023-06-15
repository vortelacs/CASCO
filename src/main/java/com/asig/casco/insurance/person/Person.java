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
    @JdbcTypeCode(SqlTypes.VARCHAR)
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
