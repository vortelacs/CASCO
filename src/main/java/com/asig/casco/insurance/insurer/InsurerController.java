package com.asig.casco.insurance.insurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/insurer")
public class InsurerController {

    private final InsurerService insurerService;

    @Autowired
    public InsurerController(InsurerService insurerService) {
        this.insurerService = insurerService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Insurer>> getInsurance(@PathVariable UUID id) {
        return new ResponseEntity<>(insurerService.getInsurer(id), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Insurer>> getInsurers() {
        return new ResponseEntity<>(insurerService.findAll(), HttpStatus.OK);
    }
}
