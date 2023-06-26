package com.asig.casco.tariff.age;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class TariffDTO {

    private String insurer;
    private String insuranceType;
    private String vehicleType;
    private int age;

    public boolean getIsFranchise() {
        return isFranchise;
    }

    public void setIsFranchise(boolean franchise) {
        isFranchise = franchise;
    }

    private boolean isFranchise;

    // getters and setters
}