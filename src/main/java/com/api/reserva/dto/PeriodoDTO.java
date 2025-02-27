package com.api.reserva.dto;

import com.api.reserva.entity.Periodo;
import com.api.reserva.enums.PeriodoAmbiente;

import java.time.LocalTime;

public class PeriodoDTO {
    private Long id;

    private PeriodoAmbiente periodoAmbiente;
    private LocalTime inicia;
    private LocalTime termina;

    public PeriodoDTO() {}

    public PeriodoDTO(PeriodoAmbiente periodoAmbiente, LocalTime inicia, LocalTime termina) {
        this.periodoAmbiente = periodoAmbiente;
        this.inicia = inicia;
        this.termina = termina;
    }

    public PeriodoDTO(Periodo periodo) {
        periodoAmbiente = periodo.getPeriodo();
        inicia = periodo.getInicia();
        termina = periodo.getTermina();
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

    public LocalTime getInicia() {
        return inicia;
    }

    public void setInicia(LocalTime inicia) {
        this.inicia = inicia;
    }

    public LocalTime getTermina() {
        return termina;
    }

    public void setTermina(LocalTime termina) {
        this.termina = termina;
    }
}
