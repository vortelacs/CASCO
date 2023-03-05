package com.asig.casco.vehicle;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private String internID;
    private String type;
    private String make;
    private String model;
    private String year;
    private long price;
    private long registrationCertificateNumber;
}
