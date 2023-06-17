package com.asig.casco.tariffCalculator.ageCategory;

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
public class AgeCategory {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private String id;

    private String categoryName;

}
