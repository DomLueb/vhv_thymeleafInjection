package de.lmis.vhv.thymeleafinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@EnableWebSecurity(debug = true)
public class ThymeleafInjectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafInjectionApplication.class, args);
    }

}
