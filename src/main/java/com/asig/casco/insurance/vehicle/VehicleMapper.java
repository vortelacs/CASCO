package com.asig.casco.insurance.vehicle;

import com.asig.casco.tariff.vehicleType.VehicleType;
import com.asig.casco.tariff.vehicleType.VehicleTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VehicleMapper {

    private final VehicleTypeService vehicleTypeService;

    public Vehicle toEntity(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake(dto.getMake());
        vehicle.setModel(dto.getModel());
        vehicle.setYear(dto.getYear());
        vehicle.setType(vehicleTypeService.getVehicleTypeByTypeName(dto.getType()));
        vehicle.setPrice(dto.getCarPrice());
        vehicle.setCertificateNumber(dto.getCertificateNumber());
        vehicle.setRegistrationNumber(dto.getRegistrationNumber());
        return vehicle;
    }

    public VehicleDTO toDTO(Vehicle vehicle) {
        VehicleDTO dto = new VehicleDTO();
        dto.setMake(vehicle.getMake());
        dto.setModel(vehicle.getModel());
        dto.setYear(vehicle.getYear());
        dto.setType(vehicle.getType().getId().toString());
        dto.setCarPrice(vehicle.getPrice());
        dto.setCertificateNumber(vehicle.getCertificateNumber());
        dto.setRegistrationNumber(vehicle.getRegistrationNumber());
        return dto;
    }
}