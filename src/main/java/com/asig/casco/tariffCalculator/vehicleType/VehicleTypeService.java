package com.asig.casco.tariffCalculator.vehicleType;

import org.springframework.stereotype.Service;

@Service
public class VehicleTypeService {

    VehicleTypeRepository vehicleTypeRepository;

    public VehicleTypeService(VehicleTypeRepository vehicleTypeRepository){
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public VehicleType getVehicleTypeByTypeName(String typeName){
        return vehicleTypeRepository.findByTypeName(typeName);
    }
}
