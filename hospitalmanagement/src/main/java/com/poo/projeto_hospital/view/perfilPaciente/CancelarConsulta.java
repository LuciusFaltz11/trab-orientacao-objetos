/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.view.perfilPaciente;

import javax.swing.*;

import com.poo.projeto_hospital.controller.CancelarConsultaListener;
import com.poo.projeto_hospital.controller.RetornarAreaPaciente;
import com.poo.projeto_hospital.model.Consulta;
import com.poo.projeto_hospital.model.ConsultaListItem;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.persistence.MedicoPersistence;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CancelarConsulta extends PadraoPerfilPaciente {
    private Usuario paciente;
    private DefaultListModel<ConsultaListItem> listaModel;
    private JList<ConsultaListItem> listaConsultas;

    public CancelarConsulta(Usuario paciente) {
        this.paciente = paciente;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public DefaultListModel<ConsultaListItem> getListaModel() {
        return listaModel;
    }

    public JList<ConsultaListItem> getListaConsultas() {
        return listaConsultas;
    }

    public void createAndShowGUI() {
        JFrame frame = criarFrame("Perfil do paciente");

        createToolbar(frame, paciente);
        criarTitulo(frame, "Cancelar Consulta");
        renderConsultasFrame(frame);

        frame.setVisible(true);
    }

    private void renderConsultasFrame(final JFrame frame) {
        List<Consulta> consultas = paciente.getConsultas();
        listaModel = new DefaultListModel<>();
        for (Consulta consulta : consultas) {
            ConsultaListItem listItem = new ConsultaListItem(consulta.getId(), consulta.getDetalhesConsultaToCancel());
            listaModel.addElement(listItem);
        }

        listaConsultas = new JList<>(listaModel);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Título do painel
        JLabel tituloLabel = new JLabel("Consultas");
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tituloLabel.setFont(new Font(null, Font.BOLD, 20));
        panel.add(tituloLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        if (consultas.isEmpty()) {
            JLabel semConsultasLabel = new JLabel("Você não tem consultas agendadas.");
            semConsultasLabel.setAlignmentY(Component.TOP_ALIGNMENT);
            semConsultasLabel.setFont(semConsultasLabel.getFont().deriveFont(Font.BOLD));
            panel.add(semConsultasLabel);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
        } else {
            // Subtítulo
            JLabel subtituloLabel = new JLabel("Selecione a consulta que deseja cancelar:");
            subtituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            Font fonteMaior = new Font("Arial", Font.BOLD, 18);
            subtituloLabel.setFont(fonteMaior);
            panel.add(subtituloLabel);

            // Lista de consultas com JScrollPane
            JScrollPane scrollPane = new JScrollPane(listaConsultas);
            scrollPane.setPreferredSize(new Dimension(450, 150));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            panel.add(scrollPane);

            // Botão de cancelar consulta
            JButton botaoCancelar = new JButton("Desmarcar Consulta");
            botaoCancelar.addActionListener(new CancelarConsultaListener(this, scrollPane));
            botaoCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(botaoCancelar);
        }

        // Botão de voltar
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(new RetornarAreaPaciente(paciente, frame));
        botaoVoltar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(botaoVoltar);

        frame.add(panel);
    }
}
