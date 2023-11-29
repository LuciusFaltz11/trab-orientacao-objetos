package com.poo.projeto_hospital.model;

public class Usuario extends Paciente {
    private String email;
    private char[] senha;

    public Usuario(String email, char[] senha, String nome, String cpf, String dataNascimento,
            String cidade, String estado, String sexo) {
        super(nome, cpf, dataNascimento, cidade, estado, sexo);
        this.email = email;
        this.senha = senha;
    }

    public String toFileString() {
        // Retorna uma string formatada para armazenar no arquivo
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s", email, new String(senha), getNome(), getCpf(),
                getDataNascimento(), getCidade(), getEstado(), getSexo());
    }

    public String getEmail() {
        return email;
    }

    public char[] getSenha() {
        return senha;
    }
}
