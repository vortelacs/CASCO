package com.asig.casco.insurance.insurer;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface InsurerRepository extends JpaRepository<Insurer, UUID> {

    public Insurer findByID(UUID id);

    public Insurer findByCompanyName(String companyName);

}
