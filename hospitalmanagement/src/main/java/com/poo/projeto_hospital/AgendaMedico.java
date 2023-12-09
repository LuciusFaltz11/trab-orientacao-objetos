package com.poo.projeto_hospital;

import java.util.ArrayList;
import java.util.List;

import com.poo.projeto_hospital.model.Consulta;

public class AgendaMedico {
    private List<Consulta> consultas;

    public AgendaMedico() {
        this.consultas = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}
