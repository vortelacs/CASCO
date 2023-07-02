package com.asig.casco.insurance.insurance;

import com.asig.casco.insurance.countryBlock.CountryBlock;
import com.asig.casco.insurance.insurance.dto.insurance.tariff.type.InsuranceType;
import com.asig.casco.insurance.insurer.Insurer;
import com.asig.casco.insurance.person.Person;
import com.asig.casco.insurance.vehicle.Vehicle;
import com.asig.casco.role.Role;
import com.asig.casco.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Getter
@Setter
public class Insurance {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    private InsuranceType insuranceType;

    @OneToOne
    private Vehicle vehicle;

    @ManyToOne
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "insurance_person",
            joinColumns = { @JoinColumn(name = "insurance")},
            inverseJoinColumns = { @JoinColumn(name = "person")}
    )
    private Collection<Person> persons = new ArrayList<>();

    @Column
    private Float price;

    @OneToOne(cascade = CascadeType.ALL)
    private Insurer insurer;

    @ManyToOne(cascade = CascadeType.ALL)
    private CountryBlock countryBlock;

    @Column
    private LocalDate effectiveDate;

    @Column
    private LocalDate expireDate;

    public Insurance(InsuranceType insuranceType, Float price, Vehicle vehicle, User user, Insurer insurer, CountryBlock countryBlock, LocalDate effectiveDate, LocalDate expireDate, Collection<Person> persons) {
        this.insuranceType = insuranceType;
        this.vehicle = vehicle;
        this.user = user;
        this.insurer = insurer;
        this.countryBlock = countryBlock;
        this.effectiveDate = effectiveDate;
        this.expireDate = expireDate;
        this.price = price;
        this.persons = persons;
    }

    @Column
    private String pdfLink;
}
