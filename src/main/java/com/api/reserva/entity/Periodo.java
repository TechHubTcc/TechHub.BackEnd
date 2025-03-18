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
    private LocalTime inicio;
    @Column(nullable = false)
    private LocalTime termino;

    public Periodo(){}

<<<<<<< HEAD
    public Periodo(PeriodoAmbiente periodoAmbiente, LocalTime inicio, LocalTime termino) {
        this.periodoAmbiente = periodoAmbiente;
        this.inicio = inicio;
        this.termino = termino;
    }

    public Periodo(PeriodoDTO periodoDTO) {
        this.inicio = periodoDTO.getInicio();
        this.termino = periodoDTO.getTermino();
=======
    public Periodo(PeriodoAmbiente periodoAmbiente, LocalTime inicia, LocalTime termina) {
        this.periodoAmbiente = periodoAmbiente;
        this.inicia = inicia;
        this.termina = termina;  
    }

    public Periodo(PeriodoDTO periodoDTO) {
        id = periodoDTO.getId();
        periodoAmbiente = periodoDTO.getPeriodoAmbiente();
        inicia = periodoDTO.getInicio();
        termina = periodoDTO.getTermino();
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

    public void setTermino(LocalTime termina) {
        this.termino = termina;
    }
}
