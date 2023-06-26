package com.asig.casco.insurance.countryBlock;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class CountryBlock {
    @Id
    @GeneratedValue
    @Column
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column
    String blockName;

    public CountryBlock(String blockName) {
        this.blockName = blockName;
    }
}
