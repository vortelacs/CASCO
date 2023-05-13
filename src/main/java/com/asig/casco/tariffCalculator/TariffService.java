package com.asig.casco.tariffCalculator;

import com.asig.casco.insurance.insurance.Insurance;
import com.asig.casco.tariffCalculator.ageCategory.AgeCategory;
import com.asig.casco.tariffCalculator.ageCategory.AgeCategoryRepository;
import com.asig.casco.tariffCalculator.ageCategory.AgeCategoryService;
import com.asig.casco.tariffCalculator.vehicleType.VehicleType;
import com.asig.casco.tariffCalculator.vehicleType.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TariffService {

    private TariffRepository tariffRepository;
    private AgeCategoryRepository ageCategoryRepository;
    private AgeCategoryService ageCategoryService;
    private VehicleTypeService vehicleTypeService;


    @Autowired
    public void TariffRepository(TariffRepository tariffRepository, AgeCategoryRepository ageCategoryRepository, AgeCategoryService ageCategoryService, VehicleTypeService vehicleTypeService){
        this.tariffRepository = tariffRepository;
        this.ageCategoryRepository = ageCategoryRepository;
        this.ageCategoryService = ageCategoryService;
        this.vehicleTypeService = vehicleTypeService;
    }


    private Float calculate(AgeCategory ageCategoryByCategoryName, VehicleType vehicleTypeByTypeName) {
        Tariff tariff = tariffRepository.findByAgeCategoryAndCarType(ageCategoryByCategoryName, vehicleTypeByTypeName);

        return tariff.getValue();
    }


    public Float getPrice(String vehicleType, int ageCategory){

        return calculate(ageCategoryService
                .getAgeCategoryByCategoryName(ageCategoryService.ageToAgeCategory(ageCategory).getCategoryName()),
                vehicleTypeService.getVehicleTypeByTypeName(vehicleType));
    }
}
