package com.asig.casco.insurance.insurer;

import lombok.Data;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Data
@Entity
public class Insurer {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID ID;

    private String companyName;
    private String img;
}
