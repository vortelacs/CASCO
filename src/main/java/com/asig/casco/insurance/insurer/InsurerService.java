package com.asig.casco.insurance.insurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InsurerService {

    private final InsurerRepository insurerRepository;

    @Autowired
    public InsurerService(InsurerRepository insurerRepository){
        this.insurerRepository = insurerRepository;
    }

    public Optional<Insurer> getInsurer(UUID id){
        return insurerRepository.findById(id);
    }
    public List<Insurer> findAll(){
        return insurerRepository.findAll();
    }

    public Insurer getInsurerByCompanyName(String companyName){
        return insurerRepository.findByCompanyName(companyName);
    }

}
