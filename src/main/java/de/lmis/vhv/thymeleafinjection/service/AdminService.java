package de.lmis.vhv.thymeleafinjection.service;

import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

@Service
public class AdminService {
    @RolesAllowed("SUPER_ADMIN")
    public void superAdminCall() {
        System.out.println("ADMIN access");
    }
}
