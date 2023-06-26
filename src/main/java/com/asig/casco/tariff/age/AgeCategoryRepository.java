package com.asig.casco.tariff.age;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgeCategoryRepository extends JpaRepository<AgeCategory, UUID> {

    AgeCategory getByMinAgeLessThanEqualAndMaxAgeGreaterThanEqual(int minAge, int maxAge);

}
