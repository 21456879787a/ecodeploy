package com.semillero.ecosistemas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/users/login", "/api/users/protegido").authenticated()
                                .anyRequest().permitAll()
                )
                .oauth2Login(withDefaults())
                .logout(logout ->
                        logout
//                                .logoutSuccessUrl("/api/users/inicio")
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                );
        return http.build();
    }
}