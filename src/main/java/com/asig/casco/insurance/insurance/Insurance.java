package com.asig.casco.insurance.insurance;

import com.asig.casco.insurance.countryBlock.CountryBlock;
import com.asig.casco.insurance.insurer.Insurer;
import com.asig.casco.insurance.vehicle.Vehicle;
import com.asig.casco.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="INSURANCE")
@Table(name = "insurance", schema = "casco")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID internID;

    @Column(name = "type")
    private String type;

    @OneToOne()
    @Column(name = "idVehicle")
    private Vehicle vehicleID;

    @OneToOne
    @Column(name = "idUser")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "idInsurer")
    private Insurer insurer;

    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "country_block")
    private CountryBlock countryBlock;

    @Column(name = "effective_date")
    private LocalDateTime effectiveDate;

    @Column(name = "expire_date")
    private LocalDateTime expireDate;
}
