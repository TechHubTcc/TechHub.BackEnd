package com.api.reserva.repository; // Define o pacote onde a interface está localizada

import com.api.reserva.entity.Usuario; // Importa a entidade Usuario que será manipulada pelo repositório
import org.springframework.data.jpa.repository.JpaRepository; // Importa JpaRepository do Spring Data JPA para usar métodos prontos para CRUD
import org.springframework.data.jpa.repository.Query; // Importa a anotação Query para definir consultas personalizadas
import org.springframework.data.repository.query.Param; // Importa a anotação Param para referenciar parâmetros em consultas personalizadas
import org.springframework.security.core.userdetails.UserDetails; // Importa a interface UserDetails do Spring Security para retornar os detalhes do usuário
import org.springframework.stereotype.Repository; // Importa a anotação Repository para marcar a interface como um repositório

@Repository // Marca a interface como um repositório do Spring, permitindo a injeção no contexto do Spring
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { // A interface estende JpaRepository para permitir o acesso à entidade Usuario

    // Método que verifica se já existe um usuário com o mesmo email ou telefone
    boolean existsByEmailOrTelefone(String email, String telefone);

    // Método com consulta JPQL personalizada que verifica se há outro usuário com o mesmo email ou telefone, mas com ID diferente
    @Query("SELECT COUNT(u) > 0 " + // A consulta verifica se há pelo menos um usuário que atenda às condições abaixo
            "FROM Usuario u " + // Faz a consulta na entidade Usuario
            "WHERE u.id <> :id " + // Garante que o ID do usuário na consulta seja diferente do ID informado
            "AND ((:email is not null AND u.email = :email) " + // Verifica se o email é o mesmo que o informado
            "     OR (:telefone is not null AND u.telefone = :telefone))") // Ou se o telefone é o mesmo que o informado
    boolean existsByEmailOrTelefoneAndIdNot(@Param("email") String email, // Define os parâmetros de entrada: email
                                            @Param("telefone") String telefone, // Define os parâmetros de entrada: telefone
                                            @Param("id") Long id); // Define o parâmetro de entrada: id

    // Método que encontra um usuário a partir do e-mail e retorna os detalhes de segurança (implementação do UserDetails)
    UserDetails findByEmail(String email); // Esse método é usado no processo de autenticação do Spring Security
}
// chat gpt explicou até d+Kkkkkkkkkkkkkkkkkkkkkkk