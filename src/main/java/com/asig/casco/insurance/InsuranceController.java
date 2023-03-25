package com.asig.casco.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/insurance")
public class InsuranceController {

    @Autowired
    InsuranceService insuranceService;

    @GetMapping(value = "/get")
    public Insurance getTestData(@PathVariable  Long id) {

        return insuranceService.getInsurance(id);
    }
}
