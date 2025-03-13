package com.api.reserva.dto;

import com.api.reserva.entity.Ambiente;
import com.api.reserva.enums.Aprovacao;
import com.api.reserva.enums.DiaSemana;
import com.api.reserva.enums.Disponibilidade;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

public class AmbienteDTO {
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 20, message = "Nome deve ter entre 3 e 50 caracteres.")
    private String nome;

    @Size(min = 10, max = 300, message = "Descrição deve ter entre 10 e 300 caracteres.")
    private String descricao;

    @NotBlank(message = "Identificação é obrigatória")
    @Size(min = 3, max = 6, message = "Identificação deve ter entre 3 e 6 caracteres.")
    private String identificacao;

    @NotNull(message = "Disponibilidade é obrigatória.")
    private Disponibilidade disponibilidade;

    @NotNull(message = "Tipo de de aprovação é obrigatória.")
    private Aprovacao aprovacao;

    private Set<TipoDTO> tipos = new HashSet<>();

    public AmbienteDTO() {}

    public AmbienteDTO(Long id, String nome, String descricao, String identificacao, Disponibilidade disponibilidade, Aprovacao aprovacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.identificacao = identificacao;
        this.disponibilidade = disponibilidade;
        this.aprovacao = aprovacao;
    }

    public AmbienteDTO(Ambiente ambiente) {
        id = ambiente.getId();
        nome = ambiente.getNome();
        descricao = ambiente.getDescricao();
        identificacao = ambiente.getIdentificacao();
        disponibilidade = ambiente.getDisponibilidade();
        aprovacao = ambiente.getAprovacao();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Aprovacao getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Aprovacao aprovacao) {
        this.aprovacao = aprovacao;
    }

    public Set<TipoDTO> getTipos() {
        return tipos;
    }

    public void setTipos(Set<TipoDTO> tipos) {
        this.tipos = tipos;
    }
}