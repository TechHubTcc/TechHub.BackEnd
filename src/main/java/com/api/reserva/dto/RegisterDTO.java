package com.api.reserva.dto;

import com.api.reserva.enums.UsuarioRole;

// Define o DTO para o registro de um novo usuário com email, senha e role
public record RegisterDTO(String email, String senha, UsuarioRole role) {
}
