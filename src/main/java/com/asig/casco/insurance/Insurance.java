package com.asig.casco.insurance;

import com.asig.casco.insurer.Insurer;
import com.asig.casco.person.Person;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
public class Insurance {

    private Person person;
    private Insurer insurer;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internID;

    @OneToOne
    @JoinColumn(name = "person", nullable = false)
    public Person getPerson() {
        return person;
    }

    @OneToOne
    @JoinColumn(name = "insurer", nullable = false)
    public Insurer getInsurer() {
        return insurer;
    }
    private ArrayList<String> ownersID;
    private String vehicleID;

}
