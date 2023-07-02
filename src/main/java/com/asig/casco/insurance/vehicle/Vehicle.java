package com.asig.casco.insurance.vehicle;

import com.asig.casco.tariff.vehicleType.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
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
    private float price;

    @Column
    String certificateNumber;

    public Vehicle(VehicleType type, String make, String model, int year, long price, String registrationNumber, String certificateNumber) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.certificateNumber = certificateNumber;
        this.registrationNumber = registrationNumber;
    }

    @Column
    private String registrationNumber;


}
