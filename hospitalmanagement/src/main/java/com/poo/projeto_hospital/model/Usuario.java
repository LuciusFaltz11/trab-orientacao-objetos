package com.poo.projeto_hospital.model;

public class Usuario extends Paciente {
    private String email;
    private String senha;

    public Usuario(String email, String senha, String nome, String cpf, String dataNascimento,
            String cidade, String estado, String sexo) {
        super(nome, cpf, dataNascimento, cidade, estado, sexo);
        this.email = email;
        this.senha = senha;
    }

}
