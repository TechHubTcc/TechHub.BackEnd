package com.api.reserva.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    SecurityFilter securityFilter; // Filtro de segurança personalizado

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())  // Desabilita CSRF (Cross-Site Request Forgery) para APIs
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Define que a sessão será sem estado (stateless)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()  // Permite acesso sem autenticação para login
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()  // Permite acesso sem autenticação para registro
                        .requestMatchers(HttpMethod.POST, "/usuario/salvar").hasAnyRole("COORDENADOR", "PROFESSOR")  // Exige que o usuário tenha "COORDENADOR" ou "PROFESSOR" para salvar usuário
                        .anyRequest().authenticated()  // Exige autenticação para qualquer outra rota
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) // Adiciona o filtro de segurança personalizado antes do filtro padrão
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Define o codificador de senhas como BCrypt
    }
}
