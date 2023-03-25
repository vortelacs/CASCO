package com.asig.casco.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    @Autowired
    InsuranceRepository insuranceRepository;

    public Insurance getInsurance(Long id){
        return insuranceRepository.findByInternID(id);
    }

}
