package com.asig.casco.user;

import com.asig.casco.insurance.person.Person;
import com.asig.casco.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private int ID;

    @Column
    private String password;

    @Column
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "idPerson", nullable = false)
    private Person person;

    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;
}
