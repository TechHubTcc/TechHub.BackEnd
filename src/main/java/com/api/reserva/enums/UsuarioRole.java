package com.api.reserva.enums;


public enum UsuarioRole {

    // Definindo os papéis de usuário como constantes, cada um associado a uma string.
    ESTUDANTE("estudante"),
    PROFESSOR("professor"),
    COORDENADOR("coordenador");

    private String role;

    // Construtor para atribuir o valor da role (por exemplo, "estudante")
    UsuarioRole(String role){
        this.role = role;
    }

    // Método para retornar o valor da role
    public String getRole(){
        return role;
    }
}
