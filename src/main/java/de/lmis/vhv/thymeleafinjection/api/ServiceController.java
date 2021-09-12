package de.lmis.vhv.thymeleafinjection.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    @GetMapping("/service")
    public String doService() {
        return "Service";
    }
}
