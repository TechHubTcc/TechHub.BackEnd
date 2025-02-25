package com.api.reserva.controller;

import com.api.reserva.dto.UsuarioDTO;
<<<<<<< HEAD
import com.api.reserva.exception.RegistroDuplicadoException;
import com.api.reserva.exception.SemResultadosException;
import com.api.reserva.model.UsuarioModel;
=======
import com.api.reserva.exception.SemResultadosException;
import com.api.reserva.exception.UsuarioDuplicadoException;
import com.api.reserva.entity.Usuario;
>>>>>>> usuario
import com.api.reserva.service.UsuarioService;
import com.api.reserva.util.Messages;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarTudo() {
            List<UsuarioDTO> usuarios = service.listar();
            return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<UsuarioDTO> listar(@PathVariable Long id) {
            UsuarioDTO usuario = service.listar(id);
            return ResponseEntity.ok(usuario);
    }

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioDTO> salvar(@Valid @RequestBody UsuarioDTO user) {
        return ResponseEntity.ok(service.salvar(user));
    }

    @PutMapping("/atualizartudo/{id}")
    public ResponseEntity<UsuarioDTO> atualizarTudo(@Valid @RequestBody UsuarioDTO user, @PathVariable Long id) {
        return ResponseEntity.ok(service.atualizartudo(user, id));
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioDTO> atualizar (@Valid @RequestBody UsuarioDTO user, @PathVariable Long id){
        return ResponseEntity.ok(service.atualizar(user, id));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}