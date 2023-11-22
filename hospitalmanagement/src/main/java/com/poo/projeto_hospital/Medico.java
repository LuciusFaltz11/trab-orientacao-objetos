package com.poo.projeto_hospital;

import java.util.Date;
import java.util.List;

public class Medico extends Pessoa {
    private String especialidade;
    private AgendaMedico agenda;

    public Medico(String nome, String cpf, Date dataNascimento, String especialidade) {
        super(nome, cpf, dataNascimento);
        this.especialidade = especialidade;
        this.agenda = new AgendaMedico();
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
}