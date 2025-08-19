package com.example.course_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for testing APIs without CSRF tokens
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/courses/**").permitAll() // Change to .authenticated() for protection
                .anyRequest().authenticated()
            )
            .httpBasic(); // Enable basic auth for protected endpoints

        return http.build();
    }
}
