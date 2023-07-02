package com.asig.casco.insurance.insurance.dto.insurance;

import com.asig.casco.insurance.person.PersonDTO;
import com.asig.casco.insurance.vehicle.Vehicle;
import com.asig.casco.insurance.vehicle.VehicleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class InsuranceDTO {

    private VehicleDTO vehicle;
    private List<PersonDTO> persons;
    private String insuranceType;
    private String assurancePrice;
    private String insurer;
    private String countryBlock;
    private String effectiveDate;
    private String expireDate;
    private String user;
    private Float price;

}
