package com.asig.casco.insurance.vehicle;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int internID;

    @ManyToOne(cascade = CascadeType.ALL)

    @Column(name = "")
    private UUID type;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "price")
    private long price;

    @Column(name = "registrationCertificateNumber")
    private long registrationCertificateNumber;
}
