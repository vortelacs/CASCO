package com.asig.casco.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

    private final JwtAthFilter jwtAthFilter;

    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "admin@mail.ro",
                    "1234",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),
            new User(
                    "user@mail.ro",
                    "12345",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.
                authorizeHttpRequests().
                anyRequest().
                authenticated()
                .and()
                .addFilterBefore(jwtAthFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService(){
        return email -> APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"));
    }
}
