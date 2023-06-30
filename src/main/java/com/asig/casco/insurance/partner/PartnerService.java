package com.asig.casco.insurance.partner;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PartnerService {

    private final PartnerRepository partnerRepository;

    public List<Partner> getAllPartners(){
        return partnerRepository.findAll();
    }

}
