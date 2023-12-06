package com.poo.projeto_hospital.controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.poo.projeto_hospital.view.TelaAgenda;

public class SelecionarConsulta implements ListSelectionListener {
    private final TelaAgenda tela;

    public SelecionarConsulta(TelaAgenda tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.atualizarFormulario();
    }
}
