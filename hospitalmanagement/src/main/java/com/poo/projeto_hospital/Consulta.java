package com.poo.projeto_hospital;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.poo.projeto_hospital.model.Paciente;
import com.poo.projeto_hospital.model.UsuarioMedico;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Consulta {
    String cpfPaciente;
    String cpfMedico;
    private String data;
    private String horario;
    private int duracaoMinutos;
    private String descricao;

    public Consulta(String cpfPaciente, String cpfMedico, String data, String horario, int duracao, String descricao) {
        this.cpfPaciente = cpfPaciente;
        this.cpfMedico = cpfMedico;
        this.data = data;
        this.horario = horario;
        this.duracaoMinutos = duracao;
        this.descricao = descricao;
    }

    public String getCpfMedico() {
        return cpfMedico;
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

    // validar data: já tem uma funçãao para isso
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getCpfPaciente() {
        return cpfPaciente;
    }
}
