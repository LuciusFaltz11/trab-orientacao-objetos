package com.poo.projeto_hospital;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {
    private List<Consulta> consultas;
    private String laudo;

    public Paciente(String nome, String cpf, LocalDate dataNascimento, String laudo) {
        super(nome, cpf, dataNascimento);
        this.laudo = laudo;
        this.consultas = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}
