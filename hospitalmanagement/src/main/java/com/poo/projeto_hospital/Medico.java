package com.poo.projeto_hospital;

import java.time.LocalDate;

public class Medico extends Pessoa {
    private String especialidade;
    private AgendaMedico agenda;
    private String inicioExpediente;
    private String finalExpediente;

    public Medico(String nome, String cpf, LocalDate dataNascimento, String especialidade, String inicioExpediente, String finalExpediente) {
        super(nome, cpf, dataNascimento);
        this.especialidade = especialidade;
        this.agenda = new AgendaMedico();
        this.inicioExpediente = inicioExpediente;
        this.finalExpediente = finalExpediente;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public AgendaMedico getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaMedico agenda) {
        this.agenda = agenda;
    }

    public String getInicioExpediente() {
        return inicioExpediente;
    }

    public String getFinalExpediente() {
        return finalExpediente;
    }
}