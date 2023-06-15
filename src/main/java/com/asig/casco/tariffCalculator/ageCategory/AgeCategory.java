package com.asig.casco.tariffCalculator.ageCategory;

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
public class AgeCategory {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String id;

    private String categoryName;

}
