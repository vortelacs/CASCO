package com.asig.casco.tariffCalculator;

import com.asig.casco.insurance.insurer.Insurer;
import com.asig.casco.insurance.insurer.InsurerService;
import com.asig.casco.tariffCalculator.vehicleType.VehicleType;
import com.asig.casco.tariffCalculator.vehicleType.VehicleTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TariffService {

    private final TariffRepository tariffRepository;
    private final InsurerService insurerService;
    private final VehicleTypeService vehicleTypeService;


    private Float calculate(String ageCategoryByCategoryName, VehicleType vehicleTypeByTypeName, Insurer insurer) {
        Tariff tariff = tariffRepository.findByAgeCategoryAndVehicleType(ageCategoryByCategoryName, vehicleTypeByTypeName);

        return tariff.getValue();
    }


    public Float getPrice(String vehicleType, int ageCategory, String insurerName){

        return calculate(ageToAgeCategory(ageCategory),
                vehicleTypeService.getVehicleTypeByTypeName(vehicleType),
                insurerService.getInsurerByCompanyName(insurerName)
                );
    }

    public String ageToAgeCategory(int age){

        if(age >= 0 && age <= 2){
            return "under_two";
        }
        else if(age == 3 || age == 4){
            return "between_three_and_four";
        }
        else if(age == 5 || age == 6){
            return "between_five_and_six";
        }
        else if(age >= 7 && age <= 9){
            return "between_seven_and_nine";
        }
        else
            return "above_ten";
    }
}

enum AgeCategory{
    UNDER_TWO,
    BETWEEN_THREE_AND_FOUR,
    BETWEEN_FIVE_AND_SIX,
    BETWEEN_SEVEN_AND_NINE,
    ABOVE_TEN
}
