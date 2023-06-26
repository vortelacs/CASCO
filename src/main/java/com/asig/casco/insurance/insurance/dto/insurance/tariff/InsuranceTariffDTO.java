package com.asig.casco.insurance.insurance.dto.insuranceTariff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class InsuranceTariffDTO {

    private UUID id;
    private UUID idVehicle;
    private Date effectiveDate;
    private Date expireDate;


}
