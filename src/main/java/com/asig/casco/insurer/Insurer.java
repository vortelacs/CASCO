package com.asig.casco.insurer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Insurer {
    @Id
    @GeneratedValue
    private String internID;
    private String companyName;
}
