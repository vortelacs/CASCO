package com.asig.casco.insurance.insurer;

import com.asig.casco.insurance.insurance.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InsurerRepository extends JpaRepository<Insurer, UUID> {

    public Insurer findByID(UUID ID);

    public Insurer findByCompanyName(String companyName);
}
