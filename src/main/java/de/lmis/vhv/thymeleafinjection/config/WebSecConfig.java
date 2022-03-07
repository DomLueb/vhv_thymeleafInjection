package de.lmis.vhv.thymeleafinjection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecConfig {
    @Bean
    @Order(100)
    public SecurityFilterChain webFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> {
                    auth.mvcMatchers("/login").permitAll();
                    auth.mvcMatchers("/admin").hasRole("ADMIN");
                    auth.anyRequest().authenticated();
                })
                .formLogin(fl -> fl.loginPage("/login"));
        return http.build();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .mvcMatchers("/login").permitAll()
//                .mvcMatchers("/admin").hasRole("ADMIN")
//                .anyRequest().authenticated().and()
//                .formLogin().loginPage("/login");
//    }


}
