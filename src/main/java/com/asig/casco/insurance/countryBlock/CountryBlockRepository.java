package com.asig.casco.insurance.countryBlock;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryBlockRepository extends JpaRepository<CountryBlock, UUID> {

    CountryBlock findCountryBlockByBlockName(String name);
}
