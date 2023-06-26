package com.asig.casco.insurance.vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {

    private String type;
    private String model;
    private String make;
    private int year;
    private float carPrice;
    private String certificateNumber;
    private String registrationNumber;
}