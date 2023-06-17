package com.asig.casco.tariffCalculator.vehicleType;

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
public class VehicleType {

    @Id
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private String id;

    @Column
    private String typeName;

}
