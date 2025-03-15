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

    public List<PeriodoDTO> listar() {
        List<Periodo> periodos = repository.findAll();
        return periodos.stream()
                .map(PeriodoDTO::new)
                .toList();
    }

    public PeriodoDTO listar(Long id) {
        Periodo periodo = repository.findById(id).orElseThrow(SemResultadosException::new);
        return new PeriodoDTO(repository.save(periodo));
    }

//    public PeriodoDTO salvar(PeriodoDTO periodoDTO){
//        LocalTime inicioFormatdo =LocalTime.parse(periodoDTO.getInicio().toString(), DateTimeFormatter.ISO_LOCAL_TIME);
//        LocalTime terminoFormatado = LocalTime.parse(periodoDTO.getInicio().toString(), DateTimeFormatter.ISO_LOCAL_TIME);
//        if(inicioFormatado.compareTo(terminoFormatado) < 0) {
//            //Exception
//        }
//        Periodo periodo = new
//        return new PeriodoDTO(repository.save())
//    }
}
