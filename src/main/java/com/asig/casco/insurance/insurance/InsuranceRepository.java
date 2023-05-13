package com.asig.casco.insurance.insurance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {

    Insurance findByInternID(UUID id);

}
