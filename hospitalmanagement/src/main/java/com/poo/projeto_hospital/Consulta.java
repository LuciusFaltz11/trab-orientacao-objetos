package com.poo.projeto_hospital;

import com.poo.projeto_hospital.model.Paciente;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    private boolean validarData(String data) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        formatoData.setLenient(false);

        try {
            formatoData.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean validarHorario(String horario) {
        SimpleDateFormat formatoHorario = new SimpleDateFormat("HH:mm");
        formatoHorario.setLenient(false);

        try {
            formatoHorario.parse(horario);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
