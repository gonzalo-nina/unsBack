package com.example.unsspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    // Define un bean para el codificador de contraseñas usando BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Define un bean para el servicio de detalles de usuario en memoria
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Crea un usuario con rol "USER"
        UserDetails user = User.builder()
                .username("usuario")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();

        // Crea un usuario con rol "ADMIN"
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();

        // Retorna un InMemoryUserDetailsManager con los usuarios creados
        return new InMemoryUserDetailsManager(user, admin);
    }

    // Define un bean para la cadena de filtros de seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // Deshabilita la protección CSRF
                .csrf(csrf -> csrf.disable())
                // Configura CORS
                .cors(cors -> cors.configure(http))
                // Configura las reglas de autorización
                .authorizeHttpRequests(auth -> {
                    // Requiere autenticación para cualquier solicitud a "/api/**"
                    auth.requestMatchers("/api/**").authenticated();
                    // Permite todas las demás solicitudes sin autenticación
                    auth.anyRequest().permitAll();
                })
                // Configura la política de creación de sesiones como STATELESS
                .sessionManagement(session -> 
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Habilita la autenticación básica HTTP
                .httpBasic(basic -> {})
                .build();
    }
}