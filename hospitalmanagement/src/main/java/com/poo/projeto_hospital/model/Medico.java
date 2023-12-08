package com.poo.projeto_hospital.model;

import com.google.gson.annotations.SerializedName;
import com.poo.projeto_hospital.AgendaMedico;
import com.poo.projeto_hospital.model.Pessoa;
import com.poo.projeto_hospital.view.TelaAgenda;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa {

    protected String especialidade;
    // protected TelaAgenda agenda;
    protected String inicioExpediente;
    protected String finalExpediente;

    public Medico(String nome, String cpf, String dataNascimento, String cidade, String estado, String sexo,
            String especialidade, String inicioExpediente,
            String finalExpediente) {
        super(nome, cpf, dataNascimento, cidade, estado, sexo);
        this.especialidade = especialidade;
        // this.agenda = new TelaAgenda(this);
        this.inicioExpediente = inicioExpediente;
        this.finalExpediente = finalExpediente;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getInicioExpediente() {
        return inicioExpediente;
    }

    public String getFinalExpediente() {
        return finalExpediente;
    }

    /*
     * public void getAgenda() {
     * agenda.desenha();
     * }
     */

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    public ArrayList<String> getHorarios(){
        ArrayList<String> horarios = new ArrayList<>();
        int intervaloMinutos = 30;

        // Converter horários para minutos
        int inicioMinutos = converterParaMinutos(inicioExpediente);
        int fimMinutos = converterParaMinutos(finalExpediente);

        // Adicionar horários ao longo do intervalo
        for (int minutos = inicioMinutos; minutos <= fimMinutos; minutos += intervaloMinutos) {
            String horarioFormatado = converterParaHorario(minutos);
            horarios.add(horarioFormatado);
        }

        return horarios;
    }

    private int converterParaMinutos(String horario) {
        String[] partes = horario.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        return horas * 60 + minutos;
    }

    private String converterParaHorario(int minutos) {
        int horas = minutos / 60;
        int minutosRestantes = minutos % 60;
        return String.format("%02d:%02d", horas, minutosRestantes);
    }
}