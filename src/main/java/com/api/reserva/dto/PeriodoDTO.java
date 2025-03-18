package com.api.reserva.dto;

import com.api.reserva.entity.Periodo;
import com.api.reserva.enums.PeriodoAmbiente;
<<<<<<< HEAD
=======
import jakarta.validation.constraints.NotBlank;
>>>>>>> tcc/ambiente
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class PeriodoDTO {
    private Long id;

<<<<<<< HEAD
    @NotNull(message = "O nome do periodo é obrigatório.")
    private PeriodoAmbiente periodoAmbiente;
    @NotNull(message = "O horário de início é obrigatório.")
    private LocalTime inicio;
    @NotNull(message = "O horário de término é obrigatório.")
    private LocalTime termino;
=======
    @NotNull(message = "Defina o nome do período.")
    private PeriodoAmbiente periodoAmbiente;
    @NotBlank(message = "Defina o início do período.")
    private LocalTime inicio;
    @NotBlank(message = "Defina o término do período.")
    private LocalTime termino           ;
>>>>>>> tcc/ambiente

    public PeriodoDTO() {}

    public PeriodoDTO(PeriodoAmbiente periodoAmbiente, LocalTime inicio, LocalTime termino) {
        this.periodoAmbiente = periodoAmbiente;
        this.inicio = inicio;
        this.termino = termino;
    }

    public PeriodoDTO(Periodo periodo) {
<<<<<<< HEAD
        periodoAmbiente = periodo.getPeriodoAmbiente();
        inicio = periodo.getInicio();
        termino = periodo.getTermino();
=======
        id = periodo.getId();
        periodoAmbiente = periodo.getPeriodoAmbiente();
        inicio = periodo.getInicia();
        termino = periodo.getTermina();
>>>>>>> tcc/ambiente
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
