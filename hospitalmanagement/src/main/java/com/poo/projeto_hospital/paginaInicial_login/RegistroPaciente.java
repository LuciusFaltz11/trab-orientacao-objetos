package com.poo.projeto_hospital.paginaInicial_login;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RegistroPaciente extends FormatacaoInicial {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Hospital Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(768, 768);
        frame.setResizable(false);

        criarTitulo(frame, "Registro de Paciente");
        criaPainelImagem(frame, "hospitalmanagement/src/main/resources/images/iconeRegistro.png");
        formuláriosInfoPaciente(frame);

        frame.pack();
        frame.setVisible(true);
    }

    private static void formuláriosInfoPaciente(JFrame frame) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel leftPanel = new JPanel();
        // Adicione os componentes ao leftPanel

        JPanel rightPanel = new JPanel();
        // Adicione os componentes ao rightPanel

        panel.add(leftPanel);
        panel.add(rightPanel);

        frame.getContentPane().add(panel, BorderLayout.SOUTH);
    }

}
