/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.model;

import java.util.ArrayList;
import java.util.List;

import com.poo.projeto_hospital.persistence.ConsultaPersistence;

public class Paciente extends Pessoa {
    private List<Consulta> consultas;
    private String laudo;

    public Paciente(String nome, String cpf, String dataNascimento, String cidade, String estado, String sexo) {
        super(nome, cpf, dataNascimento, cidade, estado, sexo);
        this.laudo = null;
        this.consultas = new ArrayList<>();
    }

    public List<Consulta> getConsultas() {
        ConsultaPersistence consultaPersistence = new ConsultaPersistence();
        return consultaPersistence.findByPaciente(this.getCpf());
    }
}
