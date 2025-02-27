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
    private PeriodoAmbiente periodo;
    @Column(nullable = false)
    private LocalTime inicia;
    @Column(nullable = false)
    private LocalTime termina;

    public Periodo(){}

    public Periodo(PeriodoAmbiente periodo, LocalTime inicia, LocalTime termina) {
        this.periodo = periodo;
        this.inicia = inicia;
        this.termina = termina;
    }

    public Periodo(PeriodoDTO period) {
        this.inicia = period.getInicia();
        this.termina = period.getTermina();
    }

    public Long getId() {
        return id;
    }

    public PeriodoAmbiente getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoAmbiente periodo) {
        this.periodo = periodo;
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
