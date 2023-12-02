package com.poo.projeto_hospital;

import com.poo.projeto_hospital.model.Paciente;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private String data;
    private String horario;
    private int duracaoMinutos;

    public Consulta(Paciente paciente, Medico medico, String data, String horario, int duracao) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.horario = horario;
        this.duracaoMinutos = duracao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getHorario() {
        return horario;
    }

    public String getData() {
        return data;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
}
