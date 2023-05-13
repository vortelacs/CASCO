package com.asig.casco.insurance.insurer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Insurer {
    @Id
    @GeneratedValue
    private int internID;
    private String companyName;
}
