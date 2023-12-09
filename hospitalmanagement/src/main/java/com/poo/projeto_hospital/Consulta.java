package com.poo.projeto_hospital;

import com.poo.projeto_hospital.persistence.MedicoPersistence;
import com.poo.projeto_hospital.persistence.PacientePersistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Consulta {
    int id;
    String cpfPaciente;
    String cpfMedico;
    private String data;
    private String horario;
    private int duracaoMinutos;
    private String descricao;
    

    // validar os parametros do construtor (data e horario)
    public Consulta(int id, String cpfPaciente, String cpfMedico, String data, String horario, int duracao, String descricao) {
        this.id = id;
        this.cpfPaciente = cpfPaciente;
        this.cpfMedico = cpfMedico;
        this.data = data;
        this.horario = horario;
        this.duracaoMinutos = duracao;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
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

    public String getPacienteNome() {
        PacientePersistence paciente = new PacientePersistence();
        return paciente.findByCpf(cpfPaciente).getNome();
    }

    public String getPacienteSexo() {
        PacientePersistence paciente = new PacientePersistence();
        return paciente.findByCpf(cpfPaciente).getSexo();
    }

    public String getPacienteDataNascimento() {
        PacientePersistence paciente = new PacientePersistence();
        return paciente.findByCpf(cpfPaciente).getDataNascimento();
    }

    public String getPacienteCidade() {
        PacientePersistence paciente = new PacientePersistence();
        return paciente.findByCpf(cpfPaciente).getCidade();
    }

    public String getPacienteEstado() {
        PacientePersistence paciente = new PacientePersistence();
        return paciente.findByCpf(cpfPaciente).getEstado();
    }

    public String getNomeMedico() {
        MedicoPersistence medico = new MedicoPersistence();
        return medico.findByCpf(cpfMedico).getNome();
    }

    public String getEspecialidadeMedico() {
        MedicoPersistence medico = new MedicoPersistence();
        return medico.findByCpf(cpfMedico).getEspecialidade();
    }

    @Override
    public String toString() {
        return "Data e Hora: " + data + " as " + horario + " | Paciente: " + getPacienteNome() + " | Duracao: "
                + duracaoMinutos + " minutos.";
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public String setCPFpaciente(String cpfPaciente) {
        return this.cpfPaciente = cpfPaciente;
    }

    public String setCPFmedico(String cpfMedico) {
        return this.cpfMedico = cpfMedico;
    }

    public String getDetalhesConsulta() {
        return "Data e Hora: " + data + " às " + horario + ", Médico: " + getNomeMedico() + ", Especialidade: "
                + getEspecialidadeMedico() + ".";
    }

    public String getDetalhesConsultaToCancel() {
        return "Dia" + data + " às " + horario + ", com: " + getNomeMedico() + " - "
                + getEspecialidadeMedico() + ".";
    }

    
}
