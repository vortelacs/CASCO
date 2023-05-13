package com.asig.casco.insurance.countryBlock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name="PERSON")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country_block", schema = "casco")
public class CountryBlock {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID
            internID;

    @Column(name = "block_name")
    String blockName;
}
