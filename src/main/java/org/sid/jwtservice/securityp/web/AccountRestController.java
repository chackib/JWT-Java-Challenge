package org.sid.jwtservice.securityp.web;


import lombok.Data;
import org.sid.jwtservice.securityp.entities.AppRole;
import org.sid.jwtservice.securityp.entities.AppUser;
import org.sid.jwtservice.securityp.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class AccountRestController {
    private AccountService accountService;


    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AppUser> appUser(){
        return accountService.listUsers();
    }

    @PostMapping
    public AppUser saveUser(@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }

    @PostMapping(path="/roles")
    public AppRole saveRole(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }

    @PostMapping
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
        accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName() );
    }
}

