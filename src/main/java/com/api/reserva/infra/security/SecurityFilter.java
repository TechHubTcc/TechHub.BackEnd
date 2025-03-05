package com.api.reserva.infra.security;


import com.api.reserva.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    UsuarioRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request); // Recupera o token do header da requisição
        if(token != null){
            var email = tokenService.validateToken(token);  // Valida o token
            UserDetails user = userRepository.findByEmail(email); // Recupera o usuário pelo e-mail

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()); // Cria o objeto de autenticação
            SecurityContextHolder.getContext().setAuthentication(authentication); // Define a autenticação no contexto de segurança
        }
        filterChain.doFilter(request, response); // Prossegue com o filtro
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", ""); // Remove o prefixo "Bearer " do token
    }
}

