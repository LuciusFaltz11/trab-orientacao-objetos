/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.controller;

import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.view.perfilPaciente.AreaPaciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetornarAreaPaciente implements ActionListener {
    private Usuario paciente;
    private JFrame frame;

    public RetornarAreaPaciente(Usuario paciente, JFrame frame) {
        this.paciente = paciente;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AreaPaciente(paciente).createAndShowGUI();
        frame.dispose();
    }
}
