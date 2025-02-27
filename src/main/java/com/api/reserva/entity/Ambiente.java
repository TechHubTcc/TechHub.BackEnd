package com.api.reserva.entity;

import com.api.reserva.dto.AmbienteDTO;
import com.api.reserva.enums.Aprovacao;
import com.api.reserva.enums.Disponibilidade;
import com.api.reserva.enums.Tipo;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_ambiente")
public class Ambiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false, unique = true)
    private String identificacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Aprovacao aprovacao;

    public Ambiente() {}
    public Ambiente(String nome, String descricao, String identificacao, Tipo tipo, Disponibilidade disponibilidade, Aprovacao aprovacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.identificacao = identificacao;
        this.tipo = tipo;
        this.disponibilidade = disponibilidade;
        this.aprovacao = aprovacao;
    }

    public Ambiente(AmbienteDTO ambience) {
        id = ambience.getId();
        nome = ambience.getNome();
        descricao = ambience.getDescricao();
        identificacao = ambience.getIdentificacao();
        tipo = ambience.getTipo();
        disponibilidade = ambience.getDisponivel();
        aprovacao = ambience.getAprovacao();
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Disponibilidade getDisponivel() {
        return disponibilidade;
    }

    public void setDisponivel(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Aprovacao getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Aprovacao aprovacao) {
        this.aprovacao = aprovacao;
    }
}
