package com.asig.casco.insurance.insurance;

import com.asig.casco.user.User;
import com.asig.casco.user.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InsuranceService {
    InsuranceRepository insuranceRepository;
    UserService userService;

    @Autowired
    public InsuranceService(InsuranceRepository insuranceRepository, UserService userService){
        this.insuranceRepository = insuranceRepository;
        this.userService = userService;
    }

    public Optional<Insurance> getInsurance(UUID id){
        return insuranceRepository.findById(id);
    }

    public List<Insurance> getInsurancesByUserEmail(String email){
        return insuranceRepository.getAllByUser(userService.getUserByEmail(email));
    }

    public Insurance saveInsurance(Insurance insurance){
        return insuranceRepository.save(insurance);
    }

    public Insurance findInsuranceForPDF(User user, LocalDate date, Float price){
        return insuranceRepository.findByUserAndEffectiveDateAndPrice(user, date, price);
    }

}
