package com.asig.casco.tariffCalculator;

import com.asig.casco.tariffCalculator.ageCategory.AgeCategory;
import com.asig.casco.tariffCalculator.vehicleType.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepository  extends JpaRepository<Tariff, Long> {

    Tariff findByAgeCategoryAndVehicleType(AgeCategory ageCategory, VehicleType vehicleType);
}
