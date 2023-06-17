package com.asig.casco.insurance.insurer;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.UUID;

@Data
@Entity
@Table
public class Insurer {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column
    private UUID id;

    private String companyName;
    private String img;
}
