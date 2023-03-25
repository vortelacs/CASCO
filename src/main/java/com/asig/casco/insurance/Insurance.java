package com.asig.casco.insurance;

import com.asig.casco.insurer.Insurer;
import com.asig.casco.person.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    @ElementCollection
    private ArrayList<String> ownersID;
    private String vehicleID;

}
