package com.asig.casco.insurance.insurance.dto.insurance.tariff.type;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, UUID> {

    public InsuranceType getByTypeName(String typeName);
}
