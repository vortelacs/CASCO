package com.asig.casco.user;

import com.asig.casco.insurance.person.Person;
import com.asig.casco.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column
    private String password;

    @Column
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "idPerson", nullable = false)
    private Person person;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "role_id")}
    )
    private Collection<Role> roles = new ArrayList<>();

    public User(String password, String email, Person person, Collection<Role> roles) {
        this.password = password;
        this.email = email;
        this.person = person;
        this.roles = roles;
    }
}
