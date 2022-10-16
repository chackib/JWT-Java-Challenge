package org.sid.jwtservice.securityp.repo;

import org.sid.jwtservice.securityp.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
