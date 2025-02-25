package com.api.reserva.service;

import com.api.reserva.dto.UsuarioDTO;
import com.api.reserva.entity.Usuario;
import com.api.reserva.enums.UsuarioRole;
import com.api.reserva.enums.UsuarioStatus;
import com.api.reserva.exception.SemResultadosException;
import com.api.reserva.exception.UsuarioDuplicadoException;
import com.api.reserva.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    //Listar uma pessoa
    public UsuarioDTO listar(Long id) {
        return new UsuarioDTO(repository.findById(id)
                .orElseThrow(() -> new SemResultadosException()));
    }

    //Listar todas as pessoas
    public List<UsuarioDTO> listar() {

        List<Usuario> usuarios = repository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();

    }
        //Cadastrar pessoa=-
        public UsuarioDTO salvar (UsuarioDTO user){
            //validação de duplicidade
            if (repository.existsByEmailOrTelefone(user.getEmail(), user.getTelefone())) {
                throw new UsuarioDuplicadoException();
            }
            Usuario usuario = new Usuario(user);
            usuario.setStatus(UsuarioStatus.ATIVO);
            usuario.setRole(UsuarioRole.ESTUDANTE);
            return new UsuarioDTO(repository.save(usuario));
        }

        //Atualizar pessoa
        public UsuarioDTO atualizartudo (UsuarioDTO user, Long id){
            //verificando existencia no banco
            Usuario usuario = repository.findById(id).orElseThrow(() -> new SemResultadosException("atualização."));

            if (repository.existsByEmailOrTelefoneAndIdNot(user.getEmail(), user.getTelefone(), id)) {
                throw new UsuarioDuplicadoException();
            }
            usuario.setNome(user.getNome());
            usuario.setEmail(user.getEmail());
            usuario.setSenha(user.getSenha());
            usuario.setTelefone(user.getTelefone());
            usuario.setGenero(user.getGenero());
            usuario.setStatus(user.getStatus());
            usuario.setRole(user.getRole());
            return new UsuarioDTO(repository.save(usuario));
        }

        public UsuarioDTO atualizar (UsuarioDTO user, Long id){
            Usuario usuario = repository.findById(id).orElseThrow(() -> new SemResultadosException("atualização."));

            if (!user.getNome().equals(usuario.getNome())) {
                usuario.setNome(user.getNome());
            }

            if (!user.getEmail().equals(usuario.getEmail())) {
                usuario.setEmail(user.getEmail());
            }

            if (!user.getSenha().equals(usuario.getSenha())) {
                usuario.setSenha(user.getSenha());
            }

            if (user.getTelefone().length() == 11) {
                if (!user.getTelefone().equals(usuario.getTelefone())) {
                    String telefone = user.getTelefone();
                    telefone.replace(" ", "");
                    telefone.replace("-", "");
                    usuario.setTelefone(user.getTelefone());
                }
            }

            if (!user.getGenero().equals(usuario.getGenero())) {
                usuario.setGenero(user.getGenero());
            }

            if (!user.getStatus().equals(usuario.getStatus())) {
                usuario.setStatus(user.getStatus());
            }

            if (!user.getRole().equals(usuario.getRole())) {
                usuario.setRole(user.getRole());
            }
            return new UsuarioDTO(repository.save(usuario));
        }

        //Deletar pessoa
        public void deletar (Long id){
            if (!repository.existsById(id)) {
                throw new SemResultadosException();
            }
            repository.deleteById(id);
        }
    }