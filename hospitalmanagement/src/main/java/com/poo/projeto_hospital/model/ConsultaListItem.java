package com.poo.projeto_hospital.model;

public class ConsultaListItem {
    private int id;
    private String detalhesConsulta;

    public ConsultaListItem(int id, String detalhesConsulta) {
        this.id = id;
        this.detalhesConsulta = detalhesConsulta;
    }

    public int getId() {
        return id;
    }

    public String getDetalhesConsulta() {
        return detalhesConsulta;
    }

    @Override
    public String toString() {
        return detalhesConsulta;
    }
}
