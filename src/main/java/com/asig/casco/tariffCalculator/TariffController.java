package com.asig.casco.tariffCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TariffController {

    TariffService tariffService;

    @Autowired
    public TariffController(TariffService tariffService){
        this.tariffService = tariffService;
    }

    @GetMapping("/tariffCalc")
    public Float getPrice(@RequestParam(value = "carType") String type, @RequestParam(value = "carAge") int carAge){
        return tariffService.getPrice(type, carAge);
    }
}
