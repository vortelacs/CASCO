package com.asig.casco.tariffCalculator.ageCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgeCategoryService {

    AgeCategoryRepository ageCategoryRepository;

    @Autowired
    public void AgeCategoryService(AgeCategoryRepository ageCategoryRepository){
        this.ageCategoryRepository = ageCategoryRepository;
    }

    public AgeCategory getAgeCategoryByCategoryName(String age){
        return ageCategoryRepository.findAgeCategoryByCategoryName(age);
    }

    public AgeCategory ageToAgeCategory(int age){

        if(age >= 0 && age <= 2){
            return ageCategoryRepository.findAgeCategoryByCategoryName("Under_Two");
        }
        else if(age == 3 || age == 4){
            return ageCategoryRepository.findAgeCategoryByCategoryName("Between_Three_and_Four");
        }
        else if(age == 5 || age == 6){
            return ageCategoryRepository.findAgeCategoryByCategoryName("Between_Five_and_Six");
        }
        else if(age >= 7 && age <= 9){
            return ageCategoryRepository.findAgeCategoryByCategoryName("Between_Seven_and_Nine");
        }
        else
            return ageCategoryRepository.findAgeCategoryByCategoryName("Above_Ten");
    }
}
