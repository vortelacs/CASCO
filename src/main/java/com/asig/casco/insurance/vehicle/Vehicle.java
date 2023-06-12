package com.asig.casco.insurance.vehicle;

import com.asig.casco.tariffCalculator.vehicleType.VehicleType;
import lombok.Data;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Data
@Entity
@Table
public class Vehicle {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID ID;

    @ManyToOne(cascade = CascadeType.ALL)
    private VehicleType type;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "price")
    private long price;

    @Column()
    private long registrationCertificateNumber;
}
