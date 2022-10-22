package org.sid.jwtservice.securityp.web;

import lombok.Data;

@Data
public class RoleUserForm {
    private String username;
    private String roleName;
}
