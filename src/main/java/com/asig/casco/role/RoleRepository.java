package com.asig.casco.role;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository {
    Role findByRoleName(String roleName);
}
