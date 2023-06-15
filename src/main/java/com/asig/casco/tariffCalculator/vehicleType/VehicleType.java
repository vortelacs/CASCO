package com.asig.casco.tariffCalculator.vehicleType;

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
@Table
public class VehicleType {

    @Id
    @Column
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String id;

    @Column
    private String typeName;

}
