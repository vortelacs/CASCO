package com.asig.casco.insurance.insurance;

import com.asig.casco.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {

    public List<Insurance> getAllByUser(User user);

}
