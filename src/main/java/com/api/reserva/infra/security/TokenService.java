package com.api.reserva.infra.security;

import com.api.reserva.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.micrometer.core.instrument.config.validate.Validated;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String GenereteToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret); // Cria o algoritmo de criptografia HMAC
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(usuario.getEmail()) // essa linha tá dando um erro por causa desse getEmail, então eu tive que gerar um bagulho lá no service, dps tem que resolver
                    .withExpiresAt(genExpirationDate()) // Define a data de expiração
                    .sign(algorithm); // Gera o token
            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Error while generetion token", exception);
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token) // Verifica a validade do token
                    .getSubject(); // Retorna o e-mail do usuário
        }catch (JWTVerificationException exception){
            return ""; // Se o token não for válido, retorna uma string vazia
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2) // Define o tempo de expiração do token como 2 horas
                .toInstant(ZoneOffset.of("-03:00"));
    }
}


