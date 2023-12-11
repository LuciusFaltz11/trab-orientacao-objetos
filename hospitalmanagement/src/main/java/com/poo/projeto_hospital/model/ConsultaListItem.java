/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
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
