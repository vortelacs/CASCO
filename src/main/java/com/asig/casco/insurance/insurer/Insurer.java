package com.asig.casco.insurance.insurer;

import com.asig.casco.role.Role;
import com.asig.casco.tariff.age.AgeCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Insurer {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column
    private String companyName;

    public Insurer(String companyName, String img) {
        this.companyName = companyName;
        this.img = img;
    }
    @Column
    private String img;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "insurer_age_category",
            joinColumns = { @JoinColumn(name = "insurer_id")},
            inverseJoinColumns = { @JoinColumn(name = "age_catoegory_id")}
    )
    private Collection<AgeCategory> ageCategories = new ArrayList<>();


}
