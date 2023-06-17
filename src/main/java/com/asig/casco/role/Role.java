package com.asig.casco.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

import javax.persistence.*;import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Role {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column
    private String roleName;
}
