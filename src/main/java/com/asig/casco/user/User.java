package com.asig.casco.user;

import com.asig.casco.insurance.person.Person;
import com.asig.casco.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

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
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Person person;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "roles_id")}
    )
    private Collection<Role> roles = new ArrayList<>();
}
