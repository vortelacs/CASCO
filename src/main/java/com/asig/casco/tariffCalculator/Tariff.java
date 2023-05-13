package com.asig.casco.tariffCalculator;

import com.asig.casco.tariffCalculator.ageCategory.AgeCategory;
import com.asig.casco.tariffCalculator.vehicleType.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name="PERSON")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tariff", schema = "tariff")
public class Tariff {

    @Id
    @GeneratedValue
    private String internID;

    @Column
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "age_fk")
    private AgeCategory ageCategory;

    @Column
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "car_type_fk")
    private VehicleType vehicleType;

    @Column(name = "tariff_value")
    private Float value;

}


