package com.asig.casco.insurance.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private String firstName;
    private String lastName;
    private String idnp;
    private String phone;
    private String email;
}