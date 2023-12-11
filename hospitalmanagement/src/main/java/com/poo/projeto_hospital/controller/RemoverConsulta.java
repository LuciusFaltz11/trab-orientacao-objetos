/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.poo.projeto_hospital.view.TelaAgenda;

public class RemoverConsulta implements ActionListener {
    private final TelaAgenda tela;

    public RemoverConsulta(TelaAgenda tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.removerConsulta();
    }
}
