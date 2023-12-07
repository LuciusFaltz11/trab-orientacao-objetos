package com.poo.projeto_hospital.model;

import com.google.gson.annotations.SerializedName;
import com.poo.projeto_hospital.AgendaMedico;
import com.poo.projeto_hospital.model.Pessoa;
import com.poo.projeto_hospital.view.TelaAgenda;

public class Medico extends Pessoa {
    @SerializedName("defaultCloseOperation")
    private String especialidade;
    private TelaAgenda agenda;
    private String inicioExpediente;
    private String finalExpediente;
    private String email;
    private char[] senha;

    public Medico(String nome, String cpf, String dataNascimento, String especialidade, String inicioExpediente,
            String finalExpediente) {
        super(nome, cpf, dataNascimento, null, null, null);
        this.especialidade = especialidade;
        this.agenda = new TelaAgenda(this);
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

    public String getEmail() {
        return email;
    }

    public char[] getSenha() {
        return senha;
    }

    public void getAgenda() {
        agenda.desenha();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}