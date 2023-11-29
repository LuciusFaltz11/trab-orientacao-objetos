package com.poo.projeto_hospital.model;

import java.time.LocalDate;

public class Pessoa {
    private final String nome;
    private final String cpf;
    private final String dataNascimento;
    private final String cidade;
    private final String estado;
    private final String sexo;

    public Pessoa(String nome, String cpf, String dataNascimento, String cidade, String estado, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
        this.estado = estado;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

}