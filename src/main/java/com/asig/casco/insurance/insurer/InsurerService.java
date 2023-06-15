package com.asig.casco.insurance.insurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InsurerService {

    private final InsurerRepository insurerRepository;

    @Autowired
    public InsurerService(InsurerRepository insurerRepository){
        this.insurerRepository = insurerRepository;
    }

    public Insurer getInsurer(UUID id){
        return insurerRepository.findByID(id);
    }
    public List<Insurer> findAll(){
        return insurerRepository.findAll();
    }

}