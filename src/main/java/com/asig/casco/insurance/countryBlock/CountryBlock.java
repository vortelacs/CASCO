package com.asig.casco.insurance.countryBlock;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private UUID ID;

    @Column
    String blockName;
}
