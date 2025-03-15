package com.api.reserva.service;

import com.api.reserva.dto.TipoDTO;
import com.api.reserva.entity.Tipo;
import com.api.reserva.exception.DadoDuplicadoException;
import com.api.reserva.exception.SemResultadosException;
import com.api.reserva.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * Serviço responsável pelo gerenciamento de operações relacionadas a entidade Tipo.
 */
@Service
public class TipoService {
    @Autowired
    private TipoRepository repository;

    /**
     * Busca um tipo específico pelo seu ID.
     *
     * @param id Identificador único do tipo
     * @return O DTO do tipo encontrado
     * @throws SemResultadosException se nenhum tipo for encontrado com o ID fornecido
     */
    public TipoDTO listar(Long id) {
        return new TipoDTO(repository.findById(id).orElseThrow(SemResultadosException::new));
    }

    /**
     * Lista todos os tipos disponíveis no sistema.
     *
     * @return Uma lista de DTOs de todos os tipos
     */
    public List<TipoDTO> listar() {
        //retorna todos os tipos
        List<Tipo> tipos = repository.findAll();
        //converte a lista de tipos para uma lista de tipoDTO
        return tipos.stream()
                .map(TipoDTO::new)
                .toList();
    }

    /**
     * Salva um novo tipo no sistema.
     *
     * @param tipoDTO O DTO contendo as informações do tipo a ser salvo
     * @return O DTO do tipo salvo com ID gerado
     * @throws DadoDuplicadoException se já existir um tipo com o mesmo nome
     */
    @Transactional
    public TipoDTO salvar(TipoDTO tipoDTO) {
        //verifica se já existe um tipo com o nome passado
        if (repository.existsByNome(tipoDTO.getNome())) {
            throw new DadoDuplicadoException("Nome");
        }
        Tipo tipo = new Tipo(tipoDTO);
        return new TipoDTO(repository.save(tipo));
    }

    /**
     * Atualiza as informações de um tipo existente.
     *
     * @param id      ID do tipo a ser atualizado
     * @param tipoDTO DTO contendo as novas informações do tipo
     * @return O DTO do tipo atualizado
     * @throws SemResultadosException se o tipo com o ID especificado não for encontrado
     * @throws DadoDuplicadoException se já existir outro tipo com o mesmo nome
     */
    @Transactional
    public TipoDTO atualizar(Long id, TipoDTO tipoDTO) {
        Tipo tipo = repository.findById(id).orElseThrow(() -> new SemResultadosException("atualização"));

        if (repository.existsByNomeAndIdNot(tipoDTO.getNome(), id)) {
            throw new DadoDuplicadoException("Nome");
        }

        if (!Objects.equals(tipo.getNome(), tipoDTO.getNome())) {
            tipo.setNome(tipoDTO.getNome());
        }

        return new TipoDTO(repository.save(tipo));
    }

    /**
     * Exclui um tipo do sistema pelo seu ID.

     * @param id ID do tipo a ser removido
     * @throws SemResultadosException se o tipo com o ID especificado não for encontrado
     */
    @Transactional
    public void excluir(Long id) {
        //bucsa o tipo pelo id, se não existir, lança uma exceção
        Tipo tipo = repository.findById(id).orElseThrow(() -> new SemResultadosException("exclusão"));
        //deleta o tipo do banco
        repository.delete(tipo);
    }
}