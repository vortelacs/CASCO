package com.asig.casco.insurance.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/insurance")
public class InsuranceController {
    InsuranceService insuranceService;
    @Autowired
    public InsuranceController(InsuranceService insuranceService){
        this.insuranceService = insuranceService;
    }
    @GetMapping(value = "/get{$id}")
    public Optional<Insurance> getInsurance(@PathVariable UUID id) {
        return insuranceService.getInsurance(id);
    }
}
