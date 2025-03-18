package com.api.reserva.service;

import com.api.reserva.dto.PeriodoDTO;
import com.api.reserva.entity.Periodo;
<<<<<<< HEAD
import com.api.reserva.exception.HorarioInvalidoException;
=======
>>>>>>> tcc/ambiente
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

<<<<<<< HEAD
    public List<PeriodoDTO> listar() {
        List<Periodo> periodos = repository.findAll();
        return periodos.stream()
                .map(PeriodoDTO::new)
                .toList();
    }

    public PeriodoDTO listar(Long id) {
=======
    public PeriodoDTO getPeriodo(Long id) {
>>>>>>> tcc/ambiente
        Periodo periodo = repository.findById(id).orElseThrow(SemResultadosException::new);
        return new PeriodoDTO(periodo);
    }

<<<<<<< HEAD
    public PeriodoDTO salvar(PeriodoDTO periodoDTO) {
        LocalTime inicioFormatado = periodoDTO.getInicio();
        LocalTime terminoFormatado = periodoDTO.getTermino();

        if (inicioFormatado.isAfter(terminoFormatado) || inicioFormatado.equals(terminoFormatado)) {
            throw new HorarioInvalidoException();
        }

        Periodo periodo = new Periodo(periodoDTO.getPeriodoAmbiente(), inicioFormatado, terminoFormatado);
=======
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
>>>>>>> tcc/ambiente
        return new PeriodoDTO(repository.save(periodo));
    }

    public PeriodoDTO atualizar(Long id, PeriodoDTO periodoDTO) {
<<<<<<< HEAD
        LocalTime inicio = periodoDTO.getInicio();
        LocalTime termino = periodoDTO.getTermino();

        if (inicio.isAfter(termino) || inicio.equals(termino)) {
            throw new HorarioInvalidoException();
        }

        Periodo periodo = repository.findById(id).orElseThrow(SemResultadosException::new);

        if(periodoDTO.getPeriodoAmbiente() != null && periodo.getInicio() != periodoDTO.getInicio()) {
            periodo.setPeriodoAmbiente(periodoDTO.getPeriodoAmbiente());
        }

        if(periodoDTO.getInicio() != null && periodo.getInicio() != periodoDTO.getInicio()) {
            periodo.setInicio(periodoDTO.getInicio());
        }

        if(periodoDTO.getTermino() != null && periodo.getTermino() != periodoDTO.getTermino()) {
            periodo.setTermino(periodoDTO.getTermino());
        }

        return new PeriodoDTO(repository.save(periodo));
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new SemResultadosException();
        }
        repository.deleteById(id);
    }
=======
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


>>>>>>> tcc/ambiente
}
