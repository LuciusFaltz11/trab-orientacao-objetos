package com.poo.projeto_hospital.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.poo.projeto_hospital.view.TelaAgenda;

public class AdicionarConsulta implements ActionListener {
    private final TelaAgenda tela;

    public AdicionarConsulta(TelaAgenda tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //tela.addConsulta();
    }
}
