package com.asig.casco.insurance.insurance.dto.insurance;


import com.asig.casco.insurance.insurance.Insurance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InsuranceMapper {

    InsuranceMapper INSTANCE = Mappers.getMapper(InsuranceMapper.class);

    @Mapping(target = "insuranceType", source = "insurance.insuranceType.type")
    @Mapping(target = "assurancePrice", source = "insurance.price")
    @Mapping(target = "insurer", source = "insurance.insurer.name")
    @Mapping(target = "countryBlock", source = "insurance.countryBlock.name")
    @Mapping(target = "effectiveDate", source = "insurance.effectiveDate")
    @Mapping(target = "expireDate", source = "insurance.expireDate")
    InsuranceDTO toDto(Insurance insurance);

    @Mapping(target = "insuranceType.type", source = "dto.insuranceType")
    @Mapping(target = "price", source = "dto.assurancePrice")
    @Mapping(target = "insurer.name", source = "dto.insurer")
    @Mapping(target = "countryBlock.name", source = "dto.countryBlock")
    @Mapping(target = "effectiveDate", source = "dto.effectiveDate")
    @Mapping(target = "expireDate", source = "dto.expireDate")
    Insurance toEntity(InsuranceDTO dto);
}