package de.lmis.vhv.thymeleafinjection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class GlobalSecConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        var simpleUser = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        Pbkdf2PasswordEncoder enc2 = new Pbkdf2PasswordEncoder();
        var p2 = enc2.encode("admin");

        var adminUser = User
                .builder()
                .username("admin")
                .password("{pbkdf2}" + p2)
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(simpleUser, adminUser);
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().mvcMatchers("/css/**");
    }
}
