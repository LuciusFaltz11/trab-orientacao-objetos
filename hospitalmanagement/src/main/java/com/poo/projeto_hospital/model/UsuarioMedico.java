package com.poo.projeto_hospital.model;

public class UsuarioMedico extends Medico {
    private String email;
    private char[] senha;

    public UsuarioMedico(String email, char[] senha, String nome, String cpf, String dataNascimento,
            String especialidade, String inicioExpediente, String finalExpediente) {
        super(nome, cpf, dataNascimento, especialidade, inicioExpediente, finalExpediente);
        this.email = email;
        this.senha = senha;
    }

    public String toFileString() {
        // Retorna uma string formatada para armazenar no arquivo
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s", email, new String(senha), getNome(), getCpf(),
                getDataNascimento(), getEspecialidade(), getInicioExpediente(), getFinalExpediente());
    }

    public String getEmail() {
        return email;
    }

    public char[] getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nEspecialidade: %s", getNome(), getEspecialidade());
    }
}