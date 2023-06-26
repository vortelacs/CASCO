package com.asig.casco.insurance.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleByID(UUID id){
        return vehicleRepository.getReferenceById(id);
    }
}
