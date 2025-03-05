package com.api.reserva.entity;

import com.api.reserva.dto.UsuarioDTO;
import com.api.reserva.enums.UsuarioGenero;
import com.api.reserva.enums.UsuarioRole;
import com.api.reserva.enums.UsuarioStatus;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private UsuarioGenero genero;
    @Enumerated(EnumType.STRING)
    private UsuarioStatus status;
    @Enumerated(EnumType.STRING)
    private UsuarioRole role;

    public Usuario(String email, String senha, UsuarioRole role) {

        this.email = email;
        this.senha = senha;
        this.role = role;
    }


    public Usuario() {}

    public Usuario(Long id, String nome, String email, String senha, String telefone,
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

    public Usuario(UsuarioDTO user) {
        id = user.getId();
        nome = user.getNome();
        email = user.getEmail();
        senha = user.getSenha();
        telefone = user.getTelefone();
        genero = user.getGenero();
        status = user.getStatus();
        role = user.getRole();
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UsuarioRole.COORDENADOR) return List.of(new SimpleGrantedAuthority("ROLE_COORDENADOR"), new SimpleGrantedAuthority("ROLE_ESTUDANTE"));
        else return List.of(new SimpleGrantedAuthority("ROLE_ESTUDANTE"));
    }

    @Override
    public String getPassword() {
        return senha;  // Retorna a senha criptografada, não o email
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}