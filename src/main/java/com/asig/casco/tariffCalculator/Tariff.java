package com.asig.casco.tariffCalculator;

import com.asig.casco.tariffCalculator.ageCategory.AgeCategory;
import com.asig.casco.tariffCalculator.vehicleType.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "tariff")
public class Tariff {

    @Id
    @Column
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String ID;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    private AgeCategory ageCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    private VehicleType vehicleType;

    private Float value;

}


