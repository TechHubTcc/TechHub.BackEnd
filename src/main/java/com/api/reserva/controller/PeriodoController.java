package com.api.reserva.controller;

import com.api.reserva.dto.PeriodoDTO;
import com.api.reserva.service.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("periodo")
public class PeriodoController {
    @Autowired
    PeriodoService service;

    @GetMapping("/listar")
    public ResponseEntity<List<PeriodoDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<PeriodoDTO> listar(@PathVariable Long id){
        return ResponseEntity.ok(service.listar(id));
    }

    @PostMapping("/salvar")
    public ResponseEntity<PeriodoDTO> salvar(@RequestBody PeriodoDTO periodoDTO) {
        return ResponseEntity.ok(service.salvar(periodoDTO));
    }

    @PatchMapping("/atualizar")
    public ResponseEntity<PeriodoDTO> atualizar(@PathVariable Long id, @RequestBody PeriodoDTO periodoDTO) {
        return ResponseEntity.ok(service.atualizar(id, periodoDTO));
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
