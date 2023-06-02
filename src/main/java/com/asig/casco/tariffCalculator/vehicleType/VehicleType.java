package com.asig.casco.tariffCalculator.vehicleType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle_type", schema = "tariff")
public class VehicleType {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private String internID;

    @Column(name = "type_name")
    private String typeName;

}
