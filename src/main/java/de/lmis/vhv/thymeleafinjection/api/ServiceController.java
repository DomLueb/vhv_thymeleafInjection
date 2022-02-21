package de.lmis.vhv.thymeleafinjection.api;

import de.lmis.vhv.thymeleafinjection.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    private final AdminService adminService;

    public ServiceController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/service")
    public String doService() {
        this.adminService.superAdminCall();
        return "Service";
    }
}
