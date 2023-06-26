package com.asig.casco.insurance.insurance;

import com.asig.casco.insurance.insurance.dto.insurance.InsuranceDTO;
import com.asig.casco.insurance.insurance.dto.insurance.tariff.type.InsuranceTypeRepository;
import com.asig.casco.insurance.person.Person;
import com.asig.casco.insurance.person.PersonDTO;
import com.asig.casco.insurance.person.PersonMapper;
import com.asig.casco.insurance.person.PersonService;
import com.asig.casco.insurance.vehicle.Vehicle;
import com.asig.casco.insurance.vehicle.VehicleMapper;
import com.asig.casco.insurance.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    private final InsuranceService insuranceService;
    private final InsuranceTypeRepository insuranceTypeRepository;
    private final VehicleService vehicleService;
    private final PersonMapper personMapper;
    private final VehicleMapper vehicleMapper;
    private final PersonService personService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService, InsuranceTypeRepository insuranceTypeRepository, VehicleService vehicleService, PersonMapper personMapper, VehicleMapper vehicleMapper, PersonService personService){
        this.insuranceService = insuranceService;
        this.insuranceTypeRepository = insuranceTypeRepository;
        this.vehicleService = vehicleService;
        this.personMapper = personMapper;
        this.vehicleMapper = vehicleMapper;
        this.personService = personService;
    }

    @GetMapping(value = "/get{$id}")
    public Optional<Insurance> getInsurance(@PathVariable UUID id) {
        return insuranceService.getInsurance(id);
    }

    @PostMapping(value = "/getByUserEmail")
    public List<InsuranceDTO> getInsurancesByUser(@RequestBody Map<String, String> json) {
        List<Insurance> insurances = insuranceService.getInsurancesByUserEmail(json.get("email"));
        return insurances.stream().map(insurance -> new InsuranceDTO(
                vehicleMapper.toDTO(insurance.getVehicle()),
                insurance.getPersons().stream().map(personMapper::toDTO).collect(Collectors.toList()),
                insurance.getInsuranceType().getTypeName(),
                insurance.getPrice().toString(),
                insurance.getVehicle().getId().toString(),
                insurance.getInsurer().getId().toString(),
                insurance.getEffectiveDate().toString(),
                insurance.getExpireDate().toString()
        )).collect(Collectors.toList());
    }

    @PostMapping(value = "/saveInsurance")
    public ResponseEntity<Insurance> saveInsurance(@RequestBody InsuranceDTO insuranceDTO) {

        Insurance insurance = new Insurance();

        Vehicle vehicle = vehicleMapper.toEntity(insuranceDTO.getVehicle());
        vehicleService.saveVehicle(vehicle);
        insurance.setVehicle(vehicle);

        List<Person> persons =   insuranceDTO.getPersons().stream().map(personMapper::toEntity).collect(Collectors.toList());
        persons.forEach(personService::savePerson);
        persons.forEach(person -> insurance.getPersons().add(person));

        // Handle other fields...

        insuranceService.saveInsurance(insurance);

        return new ResponseEntity<>(insurance, HttpStatus.CREATED);
    }
}
