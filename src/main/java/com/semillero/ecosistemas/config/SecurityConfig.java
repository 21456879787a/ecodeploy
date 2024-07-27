package com.semillero.ecosistemas.config;

import com.semillero.ecosistemas.jwt.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(withDefaults()) // Habilita la configuración de CORS
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/users/login", "/api/users/protegido").authenticated()
                                .anyRequest().permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        .successHandler((request, response, authentication) -> {
                            response.sendRedirect("http://localhost:5173");
                        })
                ).logout(logout ->
                        logout
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                );
        return http.build();
    }
}
