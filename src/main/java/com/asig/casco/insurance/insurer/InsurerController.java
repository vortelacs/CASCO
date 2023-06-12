package com.asig.casco.insurance.insurer;

import com.asig.casco.insurance.insurance.Insurance;
import com.asig.casco.insurance.insurance.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping(value = "/insurer")
public class InsurerController {

    InsurerService insurerService;

    @Autowired
    public InsurerController(InsurerService insurerService){
        this.insurerService = insurerService;
    }

    @GetMapping(value = "/get{$id}")
    public Insurer getInsurance(@PathVariable UUID id) {
        return insurerService.getInsurer(id);
    }
}
