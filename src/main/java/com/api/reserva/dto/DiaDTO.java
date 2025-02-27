package com.api.reserva.dto;

import com.api.reserva.entity.Dia;
import com.api.reserva.enums.DiaSemana;
import jakarta.validation.constraints.NotNull;

public class DiaDTO {
    private Long id;
    @NotNull(message = "O dia da semana não pode ser nulo")
    private DiaSemana diaSemana;

    public DiaDTO() {
    }

    public DiaDTO(Long id, DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public DiaDTO(Dia dia) {
        id = dia.getId();
        diaSemana = dia.getDiaSemana();
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
