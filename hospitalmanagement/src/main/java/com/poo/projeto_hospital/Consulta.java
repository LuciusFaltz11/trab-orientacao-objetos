package com.poo.projeto_hospital;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.poo.projeto_hospital.model.Paciente;

public class Consulta {
    private Paciente paciente;
    private String data;
    private String horario;
    private int duracaoMinutos;

    public Consulta(Paciente paciente, String data, String horario, int duracao) {
        this.paciente = paciente;
        this.data = data;
        this.horario = horario;
        this.duracaoMinutos = duracao;
    }

    public Paciente getPaciente() {
        return paciente;
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

    public void setData(String data) {
        this.data = data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public String toString() {
        return "Data e Hora: " + data + " as " + horario + " | Paciente: " + paciente.getNome() + " | Duracao: "
                + duracaoMinutos + " minutos.";
    }
}
