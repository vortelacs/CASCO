package com.asig.casco.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {


  User findByUsername(String username);
  User findByEmail(String email);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

}
