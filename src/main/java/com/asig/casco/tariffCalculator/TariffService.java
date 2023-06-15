package com.asig.casco.tariffCalculator;

import com.asig.casco.tariffCalculator.ageCategory.AgeCategory;
import com.asig.casco.tariffCalculator.ageCategory.AgeCategoryRepository;
import com.asig.casco.tariffCalculator.ageCategory.AgeCategoryService;
import com.asig.casco.tariffCalculator.vehicleType.VehicleType;
import com.asig.casco.tariffCalculator.vehicleType.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TariffService {

    private final TariffRepository tariffRepository;
    private final AgeCategoryRepository ageCategoryRepository;
    private final AgeCategoryService ageCategoryService;
    private final VehicleTypeService vehicleTypeService;


    @Autowired
    public TariffService(TariffRepository tariffRepository, AgeCategoryRepository ageCategoryRepository, AgeCategoryService ageCategoryService, VehicleTypeService vehicleTypeService){
        this.tariffRepository = tariffRepository;
        this.ageCategoryRepository = ageCategoryRepository;
        this.ageCategoryService = ageCategoryService;
        this.vehicleTypeService = vehicleTypeService;
    }


    private Float calculate(AgeCategory ageCategoryByCategoryName, VehicleType vehicleTypeByTypeName) {
        Tariff tariff = tariffRepository.findByAgeCategoryAndVehicleType(ageCategoryByCategoryName, vehicleTypeByTypeName);

        return tariff.getValue();
    }


    public Float getPrice(String vehicleType, int ageCategory){

        return calculate(ageCategoryService
                .getAgeCategoryByCategoryName(ageCategoryService.ageToAgeCategory(ageCategory).getCategoryName()),
                vehicleTypeService.getVehicleTypeByTypeName(vehicleType));
    }
}
