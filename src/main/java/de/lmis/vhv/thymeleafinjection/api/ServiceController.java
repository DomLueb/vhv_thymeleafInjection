package de.lmis.vhv.thymeleafinjection.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ServiceController {
    @GetMapping("/service")
    public String doService(Principal principal) {
        return "Service: " + principal;
    }
}
