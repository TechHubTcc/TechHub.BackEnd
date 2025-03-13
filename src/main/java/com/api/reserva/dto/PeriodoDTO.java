package com.api.reserva.dto;

import com.api.reserva.entity.Periodo;
import com.api.reserva.enums.PeriodoAmbiente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class PeriodoDTO {
    private Long id;

    @NotNull(message = "Defina o nome do período.")
    private PeriodoAmbiente periodoAmbiente;
    @NotBlank(message = "Defina o início do período.")
    private LocalTime inicio;
    @NotBlank(message = "Defina o término do período.")
    private LocalTime termino           ;

    public PeriodoDTO() {}

    public PeriodoDTO(PeriodoAmbiente periodoAmbiente, LocalTime inicio, LocalTime termino) {
        this.periodoAmbiente = periodoAmbiente;
        this.inicio = inicio;
        this.termino = termino;
    }

    public PeriodoDTO(Periodo periodo) {
        id = periodo.getId();
        periodoAmbiente = periodo.getPeriodoAmbiente();
        inicio = periodo.getInicia();
        termino = periodo.getTermina();
    }

    public Long getId() {
        return id;
    }

    public PeriodoAmbiente getPeriodoAmbiente() {
        return periodoAmbiente;
    }

    public void setPeriodoAmbiente(PeriodoAmbiente periodoAmbiente) {
        this.periodoAmbiente = periodoAmbiente;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getTermino() {
        return termino;
    }

    public void setTermino(LocalTime termino) {
        this.termino = termino;
    }
}
