package com.poo.projeto_hospital.view.perfilPaciente;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.poo.projeto_hospital.model.UsuarioMedico;
import com.poo.projeto_hospital.persistence.MedicoPersistence;

import java.awt.Dimension;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AreaPaciente {

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Perfil do paciente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setPreferredSize(new Dimension(500, 350));
        frame.setResizable(false);
        // acoesPaciente(frame);
        createToolbar(frame);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setLocationRelativeTo(null); // tela no centro
        frame.setVisible(true);
    }

    void acoesPaciente(JFrame frame) {
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center align the buttons
        botaoPanel.setPreferredSize(new Dimension(100, 50));

        JButton voltarButton = new JButton("Sair");
        JButton marcarConsultaButton = new JButton("Marcar consulta");
        JButton editarPerfilButton = new JButton("Editar perfil");
        JButton cancelarConsultaButton = new JButton("Cancelar consulta");

        botaoPanel.add(marcarConsultaButton);
        botaoPanel.add(editarPerfilButton);
        botaoPanel.add(cancelarConsultaButton);
        botaoPanel.add(voltarButton);
        frame.add(botaoPanel);
    }

    void createToolbar(JFrame frame) {
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        JButton marcarConsultaButton = new JButton("Marcar consulta");
        JButton editarPerfilButton = new JButton("Editar perfil");
        JButton cancelarConsultaButton = new JButton("Cancelar consulta");
        JButton sairButton = new JButton("Sair");

        toolbar.add(marcarConsultaButton);
        toolbar.add(editarPerfilButton);
        toolbar.add(cancelarConsultaButton);
        toolbar.add(sairButton);

        frame.add(toolbar);
    }

    void consultasPaciente(JFrame frame) {
        JPanel consultasPanel = new JPanel();
        consultasPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        consultasPanel.setPreferredSize(new Dimension(300, 50));

        frame.add(consultasPanel);
    }
}
