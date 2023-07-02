package com.asig.casco.insurance.insurance;

import com.asig.casco.insurance.countryBlock.CountryBlockService;
import com.asig.casco.insurance.insurance.dto.insurance.InsuranceDTO;
import com.asig.casco.insurance.insurance.dto.insurance.tariff.type.InsuranceTypeRepository;
import com.asig.casco.insurance.insurer.InsurerService;
import com.asig.casco.insurance.person.Person;
import com.asig.casco.insurance.person.PersonMapper;
import com.asig.casco.insurance.person.PersonService;
import com.asig.casco.insurance.vehicle.Vehicle;
import com.asig.casco.insurance.vehicle.VehicleMapper;
import com.asig.casco.insurance.vehicle.VehicleService;
import com.asig.casco.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.parse;

@RestController
@RequestMapping("/insurance")
@AllArgsConstructor
public class InsuranceController {
    private final InsuranceService insuranceService;
    private final InsuranceTypeRepository insuranceTypeRepository;
    private final VehicleService vehicleService;
    private final PersonMapper personMapper;
    private final CountryBlockService countryBlockService;
    private final VehicleMapper vehicleMapper;
    private final PersonService personService;
    private final InsurerService insurerService;
    private final UserService userService;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
                insurance.getExpireDate().toString(),
                insurance.getUser().getEmail(),
                insurance.getPrice()
        )).collect(Collectors.toList());
    }

    @PostMapping(value = "/saveInsurance")
    public ResponseEntity<Insurance> saveInsurance(@RequestBody InsuranceDTO insuranceDTO) {
        Vehicle vehicle = vehicleMapper.toEntity(insuranceDTO.getVehicle());
        vehicleService.saveVehicle(vehicle);

        List<Person> persons = insuranceDTO.getPersons().stream()
                .map(personDTO -> {
                    Person person = personMapper.toEntity(personDTO);
                    personService.savePerson(person);
                    return person;
                })
                .collect(Collectors.toList());

        Insurance insurance = new Insurance();
        insurance.setVehicle(vehicle);
        insurance.setPersons(persons);
        insurance.setCountryBlock(countryBlockService.getByName(insuranceDTO.getCountryBlock()));
        insurance.setInsurer(insurerService.getInsurerByCompanyName(insuranceDTO.getInsurer()));
        insurance.setPrice(insuranceDTO.getPrice());
        insurance.setUser(userService.getUserByEmail(insuranceDTO.getUser()));

        insurance.setEffectiveDate(LocalDate.parse(insuranceDTO.getEffectiveDate(), dateFormatter));
        insurance.setExpireDate(LocalDate.parse(insuranceDTO.getExpireDate(), dateFormatter));
        insurance.setInsuranceType(insuranceTypeRepository.getByTypeName(insuranceDTO.getInsuranceType()));

        insuranceService.saveInsurance(insurance);

        return new ResponseEntity<>(insurance, HttpStatus.CREATED);
    }
}
