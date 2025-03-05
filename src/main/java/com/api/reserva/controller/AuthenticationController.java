package com.api.reserva.controller;

import com.api.reserva.dto.AuthenticationDTO;
import com.api.reserva.dto.LoginResponseDTO;
import com.api.reserva.dto.RegisterDTO;
import com.api.reserva.entity.Usuario;
import com.api.reserva.infra.security.TokenService;
import com.api.reserva.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth") // Define o caminho base para os endpoints dessa classe
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager; // Responsável pela autenticação de usuários

    @Autowired
    private UsuarioRepository repository; // Repositório para consultar usuários no banco de dados

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Utilizado para criptografar senhas

    @Autowired
    private TokenService tokenService; // Serviço para gerar o token JWT

    // Endpoint de login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
        // Cria um token de autenticação com o email e senha recebidos
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword); // Autentica o usuário

        // Gera um token JWT para o usuário autenticado
        var token = tokenService.GenereteToken((Usuario) auth.getPrincipal());

        // Retorna o token para o cliente
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    // Endpoint de registro de novo usuário
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        // Verifica se já existe um usuário com o email fornecido
        if (repository.findByEmail(data.email()) != null)
            return ResponseEntity.badRequest().build(); // Se existir, retorna erro

        // Criptografa a senha do novo usuário
        String encryptedPassword = passwordEncoder.encode(data.senha());
        // Cria um novo usuário com o email, senha criptografada e role fornecido
        Usuario newUser = new Usuario(data.email(), encryptedPassword, data.role());

        // Salva o novo usuário no banco de dados
        repository.save(newUser);

        // Retorna resposta de sucesso
        return ResponseEntity.ok().build();
    }
}
