package com.poo.projeto_hospital.model;

import com.google.gson.annotations.SerializedName;
import com.poo.projeto_hospital.AgendaMedico;
import com.poo.projeto_hospital.model.Pessoa;
import com.poo.projeto_hospital.view.TelaAgenda;

public class Medico extends Pessoa {
    @SerializedName("defaultCloseOperation")
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
}