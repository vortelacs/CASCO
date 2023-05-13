package com.asig.casco.user;

import com.asig.casco.insurance.person.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", schema = "casco")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int internID;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    @Column
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPerson", nullable = false)
    private Person person;

}
