package com.asig.casco.insurance.insurer;

import com.asig.casco.tariff.age.AgeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InsurerRepository extends JpaRepository<Insurer, UUID> {

    public Insurer findByCompanyName(String companyName);

}
