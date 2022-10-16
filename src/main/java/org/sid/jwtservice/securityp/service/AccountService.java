package org.sid.jwtservice.securityp.service;

import org.sid.jwtservice.securityp.entities.AppRole;
import org.sid.jwtservice.securityp.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
}
