package com.asig.casco.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequest {

    private String firstName;
    private String lastName;
    private String idnp;
    private String phone;
    private String email;
    private String password;
}
