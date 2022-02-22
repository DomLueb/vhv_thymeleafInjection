package de.lmis.vhv.thymeleafinjection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ApiSecConfig {
    @Bean
    @Order(99)
    public SecurityFilterChain serviceFilterChain(HttpSecurity http) throws Exception {
        http.mvcMatcher("/service")
                .authorizeRequests(auth -> auth.anyRequest().hasRole("ADMIN"))
                .httpBasic(withDefaults());
        return http.build();
    }
//
//        @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.mvcMatcher("/service")
//                .authorizeRequests()
//                .anyRequest().hasRole("ADMIN")
//                .and()
//                .httpBasic();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("servAcc").password("{noop}servAcc").roles("ADMIN");
//    }
}
