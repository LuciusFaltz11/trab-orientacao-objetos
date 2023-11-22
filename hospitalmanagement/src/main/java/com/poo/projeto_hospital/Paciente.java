package com.poo.projeto_hospital;

import java.util.Date;
import java.util.List;

public class Paciente extends Pessoa {
    private List<Consulta> consultas;
    private String laudo;

    public Paciente(String nome, String cpf, Date dataNascimento, String laudo) {
        super(nome, cpf, dataNascimento);
        this.laudo = laudo;
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}
