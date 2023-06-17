package com.asig.casco.insurance.vehicle;

import com.asig.casco.tariffCalculator.vehicleType.VehicleType;
import lombok.Data;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table
public class Vehicle {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    private VehicleType type;

    @Column
    private String make;

    @Column
    private String model;

    @Column
    private int year;

    @Column
    private long price;

    @Column
    private long registrationCertificateNumber;
}
