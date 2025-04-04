package com.api.reserva.entity;

import com.api.reserva.dto.AmbienteDTO;
import com.api.reserva.enums.Aprovacao;
import com.api.reserva.enums.Disponibilidade;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_ambiente")
public class Ambiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    private String descricao;

    @Column(nullable = false, unique = true, length = 6)
    private String identificacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Aprovacao aprovacao;

    // Mapeamento muitos para muitos entre Ambiente e Categoria
    @ManyToMany
    @JoinTable(
            name = "tb_ambiente_categoria",
            joinColumns = @JoinColumn(name = "id_ambiente"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private Set<Categoria> categorias = new HashSet<>();



    public Ambiente() {
    }

    public Ambiente(String nome, String descricao, String identificacao, Disponibilidade disponibilidade, Aprovacao aprovacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.identificacao = identificacao;
        this.disponibilidade = disponibilidade;
        this.aprovacao = aprovacao;
    }

    public Ambiente(AmbienteDTO ambienteDTO) {
        id = ambienteDTO.getId();
        nome = ambienteDTO.getNome();
        descricao = ambienteDTO.getDescricao();
        identificacao = ambienteDTO.getIdentificacao();
        disponibilidade = ambienteDTO.getDisponibilidade();
        aprovacao = ambienteDTO.getAprovacao();
//        categorias = ambienteDTO.getCategorias()
//                .stream()
//                .map(Categoria::new)
//                .collect(Collectors.toSet());
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

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }
}
