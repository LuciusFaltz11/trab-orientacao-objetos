package com.poo.projeto_hospital.model;

import java.util.ArrayList;
import java.util.List;

import com.poo.projeto_hospital.Consulta;
import com.poo.projeto_hospital.persistence.ConsultaPersistence;

public class Paciente extends Pessoa {
    private List<Consulta> consultas;
    private String laudo;

    public Paciente(String nome, String cpf, String dataNascimento, String cidade, String estado, String sexo) {
        super(nome, cpf, dataNascimento, cidade, estado, sexo);
        this.laudo = null;
        this.consultas = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> getConsultas() {
        ConsultaPersistence consultaPersistence = new ConsultaPersistence();
        List<Consulta> consultas = consultaPersistence.findByPaciente(this.getCpf());
        return consultas;
    }
}
