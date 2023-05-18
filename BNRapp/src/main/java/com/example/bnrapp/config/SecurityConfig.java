package com.example.bnrapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/currencies/**").permitAll()
                .antMatchers("/api/**").permitAll()
                .anyRequest().authenticated() // Restrict access to other endpoints
                .and()
                .formLogin(); // Enable form-based authentication
    }
}

