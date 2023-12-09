package com.poo.projeto_hospital.controller;

import com.poo.projeto_hospital.model.ConsultaListItem;
import com.poo.projeto_hospital.persistence.ConsultaPersistence;
import com.poo.projeto_hospital.view.perfilPaciente.CancelarConsulta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelarConsultaListener implements ActionListener {
    private CancelarConsulta evento;
    private JScrollPane panel;

    public CancelarConsultaListener(CancelarConsulta evento, JScrollPane panel) {
        this.evento = evento;
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = evento.getListaConsultas().getSelectedIndex();

        if (selectedIndex != -1) {
            ConsultaListItem detalhesConsulta = evento.getListaModel().getElementAt(selectedIndex);
            ConsultaPersistence persistence = new ConsultaPersistence();
            if(!persistence.removeById(detalhesConsulta.getId())){
                JOptionPane.showMessageDialog(null, "Erro, não foi possível desmarcar a consulta.", "Erro", JOptionPane.WARNING_MESSAGE);
            }

            // Atualiza a JList após o cancelamento
            evento.getListaModel().removeElementAt(selectedIndex);
            JOptionPane.showMessageDialog(null, "Consulta desmarcada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            panel.revalidate();
        } else {
            // Exibe uma mensagem se nenhuma consulta estiver selecionada
            JOptionPane.showMessageDialog(null, "Selecione uma consulta para desmarcada.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
