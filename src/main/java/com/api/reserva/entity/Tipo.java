package com.api.reserva.entity;

import com.api.reserva.dto.AmbienteDTO;
import com.api.reserva.dto.TipoDTO;
import com.api.reserva.enums.DiaSemana;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_tipo")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String nome;

    @ManyToMany(mappedBy = "tipos")
    private Set<Ambiente> ambientes = new HashSet<>();

    public Tipo() {
    }

    public Tipo(String nome) {
        this.nome = nome;
    }

    public Tipo(TipoDTO tipoDTO) {
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

    public Set<Ambiente> getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(Set<Ambiente> ambientes) {
        this.ambientes = ambientes;
    }
}
