package com.asig.casco.insurance.countryBlock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

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
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column
    String blockName;
}
