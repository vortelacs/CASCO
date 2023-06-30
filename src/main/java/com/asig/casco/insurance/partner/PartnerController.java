package com.asig.casco.insurance.partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class PartnerController {

    private final PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping(value = "/partners")
    public ResponseEntity<?> getAllPartners() {
        Optional<List<Partner>> partnersOptional = Optional.ofNullable(partnerService.getAllPartners());

        if (partnersOptional.isPresent()) {
            return new ResponseEntity<>(partnersOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Didn't find partners", HttpStatus.BAD_REQUEST);
        }
    }
}
