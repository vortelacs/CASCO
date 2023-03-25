package com.asig.casco.insurance;

import com.asig.casco.person.Person;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.stereotype.Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    public Insurance findByInternID(Long id);
}
