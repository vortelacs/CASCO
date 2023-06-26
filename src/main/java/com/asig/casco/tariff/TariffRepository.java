package com.asig.casco.tariff;

import com.asig.casco.insurance.insurance.dto.insurance.tariff.type.InsuranceType;
import com.asig.casco.insurance.insurer.Insurer;
import com.asig.casco.tariff.age.AgeCategory;
import com.asig.casco.tariff.vehicleType.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TariffRepository  extends JpaRepository<Tariff, Long> {

    Tariff findByInsurerAndInsuranceTypeAndVehicleTypeAndAgeCategoryAndIsFranchise(Insurer insurer, InsuranceType insuranceType, VehicleType vehicleType, AgeCategory ageCategory, Boolean isFranchise);

    List<Tariff> getTariffsByInsurer(Insurer insurer);
}
