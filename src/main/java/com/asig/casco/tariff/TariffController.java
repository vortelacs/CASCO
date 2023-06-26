package com.asig.casco.tariff;

import com.asig.casco.tariff.age.TariffDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TariffController {

    TariffService tariffService;

    @Autowired
    public TariffController(TariffService tariffService){
        this.tariffService = tariffService;
    }

    @GetMapping("/tariffCalc")
    public Float getPrice(@RequestParam(value = "carType") String type, @RequestParam(value = "carAge") int carAge, @RequestParam(value = "carType") String insurerName){
        return 0.1F;
    }

    @GetMapping("/minimum")
    public double calculateMinimumTariff(@RequestParam String insurer) {
        return tariffService.calculateMinimumTariffByInsurer(insurer);
    }

    @PostMapping("/calculate")
    public double calculateTariff(@RequestBody TariffDTO tariffDTO, float carPrice) {
        return tariffService.calculateTariff(tariffDTO, carPrice);
    }
}
