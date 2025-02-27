package com.api.reserva.entity;

import com.api.reserva.dto.DiaDTO;
import com.api.reserva.enums.DiaSemana;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_dia")
public class Dia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    public Dia() {
    }

    public Dia(Long id, DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Dia(DiaDTO day){
        id = day.getId();
        diaSemana = day.getDiaSemana();
    }

    public Long getId() {
        return id;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }
}
