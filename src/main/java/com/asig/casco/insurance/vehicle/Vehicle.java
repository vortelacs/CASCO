package com.asig.casco.insurance.vehicle;

import com.asig.casco.tariffCalculator.vehicleType.VehicleType;
import lombok.Data;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
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
