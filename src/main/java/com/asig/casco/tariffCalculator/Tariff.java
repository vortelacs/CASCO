package com.asig.casco.tariffCalculator;

import com.asig.casco.tariffCalculator.ageCategory.AgeCategory;
import com.asig.casco.tariffCalculator.vehicleType.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Tariff {

    @Id
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    private AgeCategory ageCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    private VehicleType vehicleType;

    private Float value;

}


