package com.asig.casco.insurance.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InsuranceService {


    InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceService(InsuranceRepository insuranceRepository){
        this.insuranceRepository = insuranceRepository;
    }

    public Insurance getInsurance(UUID id){
        return insuranceRepository.findByInternID(id);
    }

}
