package com.api.reserva.dto;

import com.api.reserva.entity.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

public class TipoDTO {
    private Long id;

    @NotBlank(message = "Nome do tipo é obrigatório.")
    @Size(min = 3, max = 20, message = "Nome do tipo deve ter entre 3 e 20 caracteres.")
    private String nome;

    private Set<AmbienteDTO> ambientes = new HashSet<>();

    public TipoDTO() {
    }

    public TipoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoDTO(Tipo tipoDTO) {
        id = tipoDTO.getId();
        nome = tipoDTO.getNome();
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

    public Set<AmbienteDTO> getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(Set<AmbienteDTO> ambientes) {
        this.ambientes = ambientes;
    }
}
