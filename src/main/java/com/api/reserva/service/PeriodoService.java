package com.api.reserva.service;

import com.api.reserva.dto.PeriodoDTO;
import com.api.reserva.entity.Periodo;
import com.api.reserva.exception.SemResultadosException;
import com.api.reserva.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PeriodoService {
    @Autowired
    PeriodoRepository repository;

    public PeriodoDTO getPeriodo(Long id) {
        Periodo periodo = repository.findById(id).orElseThrow(SemResultadosException::new);
        return new PeriodoDTO(periodo);
    }

    public List<PeriodoDTO> listar() {
        List<Periodo> periodos = repository.findAll();
        return periodos
                .stream()
                .map(PeriodoDTO::new)
                .toList();
    }

    public PeriodoDTO salvar(PeriodoDTO periodoDTO) {
        LocalTime inicio = LocalTime.parse(periodoDTO.getInicio().toString(), DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime termino = LocalTime.parse(periodoDTO.getTermino().toString(), DateTimeFormatter.ISO_LOCAL_TIME);
        if (inicio.compareTo(termino) < 0) {
            //exception
        }
        Periodo periodo = new Periodo(periodoDTO);
        return new PeriodoDTO(repository.save(periodo));
    }

    public PeriodoDTO atualizar(Long id, PeriodoDTO periodoDTO) {
        Periodo periodo = repository.findById(id).orElseThrow(() -> new SemResultadosException("atualização"));
        LocalTime inicio = LocalTime.parse(periodoDTO.getInicio().toString(), DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime termino = LocalTime.parse(periodoDTO.getTermino().toString(), DateTimeFormatter.ISO_LOCAL_TIME);
        if (inicio.compareTo(termino) < 0) {
            //exception
        }
        periodo.setPeriodoAmbiente(periodoDTO.getPeriodoAmbiente());
        periodo.setInicia(periodoDTO.getInicio());
        periodo.setTermina(periodoDTO.getTermino());
        return new PeriodoDTO(repository.save(periodo));
    }


}
