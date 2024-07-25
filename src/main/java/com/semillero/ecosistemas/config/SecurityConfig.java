package com.semillero.ecosistemas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Desactiva CSRF
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/users/login", "/api/users/protegido").authenticated()
                                .anyRequest().permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        .successHandler((request, response, authentication) -> {
                            response.sendRedirect("http://localhost:5173");
                        })
                )
                .logout(logout ->
                        logout
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .logoutSuccessUrl("http://localhost:5173")
                );
        return http.build();
    }
}
