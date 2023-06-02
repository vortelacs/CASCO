package com.asig.casco.insurance.insurer;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Insurer {

    @Id
    private int ID;
    private String companyName;
}
