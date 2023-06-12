package com.asig.casco.insurance.insurance;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {

    Insurance findByID(UUID id);

}
