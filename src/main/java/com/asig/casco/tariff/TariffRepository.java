package com.asig.casco.tariffCalculator;

import com.asig.casco.insurance.insurance.dto.insuranceTariff.type.InsuranceType;
import com.asig.casco.insurance.insurer.Insurer;
import com.asig.casco.tariffCalculator.vehicleType.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepository  extends JpaRepository<Tariff, Long> {

    Tariff findByInsurerAndInsuranceTypeAndVehicleTypeAndAgeCategoryAndFranchise(Insurer insurer, InsuranceType insuranceType,VehicleType vehicleType, String ageCategory, Boolean isFranchise);
}
