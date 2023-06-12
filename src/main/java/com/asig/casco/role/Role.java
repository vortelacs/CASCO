package com.asig.casco.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Role {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID ID;

    @Column
    private String roleName;
}
