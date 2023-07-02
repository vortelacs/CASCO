package com.asig.casco.insurance.countryBlock;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryBlockService {

    private final CountryBlockRepository countryBlockRepository;

    public CountryBlock getByName(String name){
        return countryBlockRepository.findCountryBlockByBlockName(name);
    }
}
