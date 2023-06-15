package com.asig.casco.insurance.insurer;

import lombok.Data;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Data
@Entity
public class Insurer {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(insertable = false, updatable = false, nullable = false)
    private UUID id;

    private String companyName;
    private String img;
}
