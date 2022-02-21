package de.lmis.vhv.thymeleafinjection.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(99)
@Configuration
public class ApiSecConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.mvcMatcher("/service")
                .authorizeRequests()
                .anyRequest().hasAnyRole("ADMIN", "SUPER_ADMIN")
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("servAcc").password("{noop}servAcc").roles("ADMIN").and()
                .withUser("servAcc2").password("{noop}servAcc2").roles("SUPER_ADMIN")
        ;
    }
}
