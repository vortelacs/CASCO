package com.asig.casco.role;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo {
    Role findByRoleName(String RoleName);
}
