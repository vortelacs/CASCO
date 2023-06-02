package com.asig.casco.insurance.insurance;

import com.asig.casco.insurance.countryBlock.CountryBlock;
import com.asig.casco.insurance.insurer.Insurer;
import com.asig.casco.insurance.vehicle.Vehicle;
import com.asig.casco.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private UUID ID;

    @Column
    private String type;

    @OneToOne
    private Vehicle vehicleID;

    @OneToOne
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Insurer insurer;

    @ManyToOne(cascade = CascadeType.ALL)
    private CountryBlock countryBlock;

    @Column
    private LocalDateTime effectiveDate;

    @Column
    private LocalDateTime expireDate;
}
