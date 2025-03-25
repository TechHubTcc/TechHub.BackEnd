package com.api.reserva.dto;

import com.api.reserva.entity.Usuario;
import com.api.reserva.enums.UsuarioGenero;
import com.api.reserva.enums.UsuarioRole;
import com.api.reserva.enums.UsuarioStatus;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UsuarioDTO {
    private Long id;
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;
    @NotBlank(message = "Email é obrigatório.")
    @Email(message = "Email inválido.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Email inválido.")
    private String email;
    @NotBlank(message = "Senha é obrigatória.")
    private String senha;
    @Pattern(regexp = "^[1-9]{2}[9]{1}[0-9]{8}$", message = "Telefone inválido. Use apenas números: DDD + 9 dígitos")
    private String telefone;
    @NotNull(message = "Gênero é obrigatório.")
    @Column(nullable = false)
    private UsuarioGenero genero;
    @Column(nullable = false)
    private UsuarioStatus status;
    @Column(nullable = false)
    private UsuarioRole role;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nome, String email, String senha, String telefone,
                      UsuarioGenero genero, UsuarioStatus status, UsuarioRole role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.genero = genero;
        this.status = status;
        this.role = role;
    }

    public UsuarioDTO(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
        senha = usuario.getSenha();
        telefone = usuario.getTelefone();
        genero = usuario.getGenero();
        status = usuario.getStatus();
        role = usuario.getRole();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public UsuarioGenero getGenero() {
        return genero;
    }

    public void setGenero(UsuarioGenero genero) {
        this.genero = genero;
    }

    public UsuarioStatus getStatus() {
        return status;
    }

    public void setStatus(UsuarioStatus status) {
        this.status = status;
    }

    public UsuarioRole getRole() {
        return role;
    }

    public void setRole(UsuarioRole role) {
        this.role = role;
    }
}
