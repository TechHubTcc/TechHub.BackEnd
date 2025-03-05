package com.api.reserva.controller;

import com.api.reserva.dto.UsuarioDTO;
import com.api.reserva.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario") // Define o caminho base para os endpoints dessa classe
public class UsuarioController {

    @Autowired
    UsuarioService service; // Serviço para a lógica de manipulação de usuários

    // Endpoint para listar todos os usuários
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarTudo() {
        // Chama o serviço para listar todos os usuários
        List<UsuarioDTO> usuarios = service.listar();
        return ResponseEntity.ok(usuarios); // Retorna a lista de usuários
    }

    // Endpoint para listar um único usuário pelo ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<UsuarioDTO> listar(@PathVariable Long id) {
        // Chama o serviço para listar um usuário pelo ID
        UsuarioDTO usuario = service.listar(id);
        return ResponseEntity.ok(usuario); // Retorna o usuário encontrado
    }

    // Endpoint para salvar um novo usuário
    @PostMapping("/salvar")
    public ResponseEntity<UsuarioDTO> salvar(@Valid @RequestBody UsuarioDTO user) {
        // Chama o serviço para salvar o usuário
        return ResponseEntity.ok(service.salvar(user)); // Retorna o usuário salvo
    }

    // Endpoint para atualizar todos os dados de um usuário
    @PutMapping("/atualizartudo/{id}")
    public ResponseEntity<UsuarioDTO> atualizarTudo(@Valid @RequestBody UsuarioDTO user, @PathVariable Long id) {
        // Chama o serviço para atualizar completamente o usuário com o ID fornecido
        return ResponseEntity.ok(service.atualizartudo(user, id));
    }

    // Endpoint para atualizar parcialmente os dados de um usuário
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@Valid @RequestBody UsuarioDTO user, @PathVariable Long id){
        // Chama o serviço para atualizar parcialmente o usuário
        return ResponseEntity.ok(service.atualizar(user, id));
    }

    // Endpoint para deletar um usuário
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        // Chama o serviço para deletar o usuário com o ID fornecido
        service.deletar(id);
        return ResponseEntity.ok().build(); // Retorna resposta de sucesso
    }
}
