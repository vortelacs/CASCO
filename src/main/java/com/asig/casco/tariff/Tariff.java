package com.asig.casco.tariffCalculator;

import com.asig.casco.insurance.insurance.dto.insuranceTariff.type.InsuranceType;
import com.asig.casco.insurance.insurer.Insurer;
import com.asig.casco.tariffCalculator.vehicleType.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Tariff {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @MapsId
    private String ageCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    private Insurer insurer;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    private InsuranceType insuranceType;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    private VehicleType vehicleType;

    @Column
    private Float value;

    @Column
    private boolean isFranchise;

}


