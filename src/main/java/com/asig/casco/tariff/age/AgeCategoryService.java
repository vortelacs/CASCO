package com.asig.casco.tariff.age;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgeCategoryService {

    AgeCategoryRepository ageCategoryRepository;

    @Autowired
    public AgeCategoryService(AgeCategoryRepository ageCategoryRepository){
        this.ageCategoryRepository = ageCategoryRepository;
    }

    public AgeCategory getAgeCategoryByMinAndMaxAge(int minAge, int maxAge){
        return ageCategoryRepository.getByMinAgeLessThanEqualAndMaxAgeGreaterThanEqual(minAge, maxAge);
    }
}
