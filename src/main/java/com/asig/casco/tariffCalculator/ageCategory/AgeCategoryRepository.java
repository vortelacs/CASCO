package com.asig.casco.tariffCalculator.ageCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgeCategoryRepository extends JpaRepository<AgeCategory, UUID> {

    public AgeCategory findAgeCategoryByCategoryName(String categoryName);
}
