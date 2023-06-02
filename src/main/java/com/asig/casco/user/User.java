package com.asig.casco.user;

import com.asig.casco.insurance.person.Person;
import com.asig.casco.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {
    @Id
    private int internID;

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
