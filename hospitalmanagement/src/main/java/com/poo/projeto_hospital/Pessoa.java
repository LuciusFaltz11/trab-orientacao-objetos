package com.poo.projeto_hospital;

import java.time.LocalDateTime;

public class Pessoa {
    private final String nome;
    private final String cpf;
    private final LocalDateTime dataNascimento;

    public Pessoa(String nome, String cpf, LocalDateTime dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }
}