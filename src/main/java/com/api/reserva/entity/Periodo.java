package com.api.reserva.entity;

import com.api.reserva.dto.PeriodoDTO;
import com.api.reserva.enums.PeriodoAmbiente;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "tb_periodo")
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PeriodoAmbiente periodoAmbiente;
    @Column(nullable = false)
    private LocalTime inicia;
    @Column(nullable = false)
    private LocalTime termina;

    public Periodo(){}

    public Periodo(PeriodoAmbiente periodoAmbiente, LocalTime inicia, LocalTime termina) {
        this.periodoAmbiente = periodoAmbiente;
        this.inicia = inicia;
        this.termina = termina;
    }

    public Periodo(PeriodoDTO period) {
        this.inicia = period.getInicio();
        this.termina = period.getTermino();
    }

    public Long getId() {
        return id;
    }

    public PeriodoAmbiente getPeriodoAmbiente() {
        return periodoAmbiente;
    }

    public void setPeriodoAmbiente(PeriodoAmbiente periodo) {
        this.periodoAmbiente = periodo;
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
