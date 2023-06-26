package com.asig.casco.insurance.insurance.dto.insuranceTariff.type;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class InsuranceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column
    private String typeName;

}
