package com.asig.casco.tariffCalculator.ageCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name="ageCategory")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "age_category", schema = "tariff")
public class AgeCategory {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private String internID;

    @Column(name = "category_name")
    private String categoryName;

}
