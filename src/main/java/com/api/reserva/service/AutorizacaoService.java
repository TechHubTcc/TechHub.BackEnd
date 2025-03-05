package com.api.reserva.service; // Define o pacote onde o serviço está localizado

import com.api.reserva.repository.UsuarioRepository; // Importa o repositório de usuários para acessar os dados de usuários
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependência automática
import org.springframework.security.core.userdetails.UserDetails; // Importa a interface UserDetails para retornar os detalhes do usuário no Spring Security
import org.springframework.security.core.userdetails.UserDetailsService; // Importa a interface UserDetailsService para autenticação no Spring Security
import org.springframework.security.core.userdetails.UsernameNotFoundException; // Importa a exceção caso o usuário não seja encontrado
import org.springframework.stereotype.Service; // Importa a anotação Service para marcar a classe como um serviço

@Service // Anotação que marca a classe como um serviço do Spring, permitindo que ela seja gerenciada pelo Spring
public class AutorizacaoService implements UserDetailsService { // Classe que implementa UserDetailsService para fornecer autenticação de usuários

    @Autowired // Injeção automática do repositório de usuários para interagir com o banco de dados
    UsuarioRepository repository;

    @Override // Método implementado da interface UserDetailsService
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // Método para carregar os detalhes do usuário pelo nome de usuário (no caso, o e-mail)
        return repository.findByEmail(username); // Chama o repositório para encontrar o usuário pelo e-mail e retornar seus detalhes
    }
}
// talvez mandar o chat gpt explicar linha por linha não tenha sido uma das melhores ideias