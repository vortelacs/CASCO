package com.asig.casco.tariff;

import com.asig.casco.insurance.insurance.dto.insurance.tariff.type.InsuranceType;
import com.asig.casco.insurance.insurance.dto.insurance.tariff.type.InsuranceTypeRepository;
import com.asig.casco.insurance.insurer.Insurer;
import com.asig.casco.insurance.insurer.InsurerService;
import com.asig.casco.tariff.age.AgeCategory;
import com.asig.casco.tariff.age.AgeCategoryService;
import com.asig.casco.tariff.vehicleType.VehicleType;
import com.asig.casco.tariff.vehicleType.VehicleTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TariffService {

    private final TariffRepository tariffRepository;
    private final InsurerService insurerService;
    private final VehicleTypeService vehicleTypeService;
    private final AgeCategoryService ageCategoryService;
    private final InsuranceTypeRepository insuranceTypeRepository;


    private Float calculate(Insurer insurer, InsuranceType insuranceType, AgeCategory ageCategory, VehicleType vehicleType, boolean isFranchise, float carPrice) {
        Tariff tariff = tariffRepository.findByInsurerAndInsuranceTypeAndVehicleTypeAndAgeCategoryAndIsFranchise(insurer, insuranceType, vehicleType, ageCategory, isFranchise);

        return tariff.getValue() / 100 * carPrice;
    }


    public Float calculateTariff(TariffDTO tariffDTO){

        Insurer insurer = insurerService.getInsurerByCompanyName(tariffDTO.getInsurer());
        List<AgeCategory> ageCategories = (List<AgeCategory>) insurer.getAgeCategories();
        AgeCategory ageCategory = null;

        for (AgeCategory ageCat : ageCategories) {
            if (ageCat.getMinAge() <= tariffDTO.getAge() && tariffDTO.getAge() <= ageCat.getMaxAge()) {
                ageCategory = ageCat;
            }
        }

        return tariffRepository.findByInsurerAndInsuranceTypeAndVehicleTypeAndAgeCategoryAndIsFranchise (
                insurer,
                insuranceTypeRepository.getByTypeName(tariffDTO.getInsuranceType()),
                vehicleTypeService.getVehicleTypeByTypeName(tariffDTO.getVehicleType()),
                ageCategory,
                tariffDTO.getIsFranchise())
                .getValue();
    }

    public double calculateMinimumTariffByInsurer(String insurer) {
        // find the minimum tariff for the given insurer
        List<Tariff> tariffs = tariffRepository.getTariffsByInsurer(insurerService.getInsurerByCompanyName(insurer));
        // return the minimum tariff
        return tariffs.stream().mapToDouble(Tariff::getValue).min().orElse(Double.NaN);

    }
}
