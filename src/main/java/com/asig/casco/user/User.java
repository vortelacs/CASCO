package com.asig.casco.user;

import com.asig.casco.person.Person;
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
    private Person person;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internID;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;

    @OneToOne
    @JoinColumn(name = "person", nullable = false)
    public Person getPerson() {
        return person;
    }

}
